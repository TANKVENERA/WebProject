package ru.mail.mina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.mail.mina.service.dto.NewsService;
import ru.mail.mina.service.dto.UserService;
import ru.mail.mina.service.model.AdDTO;
import ru.mail.mina.service.model.AppUserPrincipal;
import ru.mail.mina.service.model.NewsDTO;
import ru.mail.mina.service.model.UserDTO;
import ru.mail.mina.web.validator.UserValidator;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Администратор on 15.08.2017.
 */
@Controller
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;
    private final NewsService newsService;


    @Autowired
    public UserController(UserService userService, UserValidator userValidator,
                          NewsService newsService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.newsService = newsService;
    }

    @RequestMapping(value = {"/close"}, method = RequestMethod.GET)
    public String showRegisterBlank(Model model) {
        model.addAttribute("user", new UserDTO());
        List<NewsDTO> newsDTOList = newsService.findAll();
        model.addAttribute("news", newsDTOList);
        return "autosale";
    }

    @RequestMapping(value = {"/new_ad"}, method = RequestMethod.GET)
    public String showAdBlank(Model model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("ad", new AdDTO());
        return "createAd";
    }


    @RequestMapping(value = {"/register", "/profile"}, method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") UserDTO userDTO, BindingResult result) {
        userValidator.validate(userDTO, result);
        if (!result.hasErrors()) {
            userService.saveUser(userDTO);
            return "redirect:/login";
        } else {
            return "filter";
        }
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model) {
        model.addAttribute("user", new UserDTO());
        return "profile";
    }


    @RequestMapping(value = "/updateBlank", method = RequestMethod.GET)
    public String showUpdateBlank(Model model) {
        model.addAttribute("user", new UserDTO());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDTO userDTO = userService.getByUserName(auth.getName());
            model.addAttribute("user", userDTO);
        }
        return "updateUser";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") UserDTO userDTO,
                             HttpServletRequest request) {
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        if (newPassword.equals(confirmPassword) && !newPassword.isEmpty() && !confirmPassword.isEmpty()) {
            userDTO.setPassword(newPassword);
            userService.update(userDTO, true);
        }
        else {
            userService.update(userDTO, false);
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUserPrincipal principal = (AppUserPrincipal) authentication.getPrincipal();
        principal.setUserName(userDTO.getUsername());
        return "redirect:/profile";
    }


    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public ModelAndView profileUser(Model model, HttpServletRequest request) {
        model.addAttribute("user", new UserDTO());
        // System.out.println( new SecurityContextHolderAwareRequestWrapper(request, "ROLE").isUserInRole("ROLE_User"));
        return new ModelAndView("autosale");
    }


}
