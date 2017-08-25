package ru.mail.mina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.mail.mina.service.dto.NewsService;
import ru.mail.mina.service.dto.UserService;
import ru.mail.mina.service.modelDTO.NewsDTO;
import ru.mail.mina.service.modelDTO.UserDTO;
import ru.mail.mina.web.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
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
    public UserController(UserService userService, UserValidator userValidator, NewsService newsService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.newsService = newsService;
    }

    @RequestMapping (value = {"/close"}, method = RequestMethod.GET)
    public String showRegisterBlank(Model model){
        model.addAttribute("user", new UserDTO());
     return "autosale";
    }

    @RequestMapping (value = {"/createAd"}, method = RequestMethod.GET)
    public String showAdBlank(Model model){
        model.addAttribute("user", new UserDTO());
        return "createAd";
    }

    @RequestMapping (value = {"/register", "/profile"}, method = RequestMethod.POST)
    public String registerUser ( @ModelAttribute("user")  UserDTO userDTO, BindingResult result) {
//        model.addAttribute("user", new UserDTO());
        System.out.println(userDTO.getUsername());
        userValidator.validate(userDTO, result);
        if (!result.hasErrors()) {
            userService.saveUser(userDTO);
            System.out.println("save");
            return "profile";
        } else {
            System.out.println("error");
            return "filter";
        }
    }


    @RequestMapping(value = "/profile" , method = RequestMethod.GET)
    public String profile(Model model){
        model.addAttribute("user", new UserDTO());
        return "profile";
    }


    @RequestMapping (value = "/filter", method = RequestMethod.GET)
    public ModelAndView profileUser (Model model, HttpServletRequest request) {
        model.addAttribute("user", new UserDTO());
        System.out.println( new SecurityContextHolderAwareRequestWrapper(request, "ROLE").isUserInRole("ROLE_User"));
        return new ModelAndView("autosale");
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String saveNews(Model model, @ModelAttribute("news") NewsDTO newsDTO ) throws IOException {

        model.addAttribute("user", new UserDTO());
        // userService.
        System.out.println(newsDTO.getText());
        return "allNews";
    }
}
