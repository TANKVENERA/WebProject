package ru.mail.mina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.mail.mina.service.dto.UserService;
import ru.mail.mina.service.modelDTO.UserDTO;
import ru.mail.mina.web.validator.UserValidator;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Администратор on 15.08.2017.
 */
@Controller
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;

    @Autowired
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @RequestMapping (value = {"/close"}, method = RequestMethod.GET)
    public String showRegisterBlank(Model model){
        model.addAttribute("user", new UserDTO());
        System.out.println("ererere");
     return "autosale";
    }

    @RequestMapping (value = "/register", method = RequestMethod.POST)
    public String registerUser ( @ModelAttribute("user")  UserDTO userDTO, BindingResult result, Model model) {
//        model.addAttribute("user", new UserDTO());
//        System.out.println(userDTO.getUsername());
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String errors, String logout) {
        System.out.println("im here");
        if (errors!=null) {
            model.addAttribute("error", "UserName or Password incorrect");
        }
        System.out.println();
        if (logout!=null) {
            model.addAttribute("message", "Logged out successfully");
        }
        return "filter";
    }

    @RequestMapping(value = "/profile" , method = RequestMethod.GET)
    public String profile(Model model){
        model.addAttribute("user", new UserDTO());
        return "profile";
    }


    @RequestMapping (value = "/filter", method = RequestMethod.GET)
    public ModelAndView profileUser (Model model) {
          model.addAttribute("user", new UserDTO());
        System.out.println("tra la la");
        return new ModelAndView("autosale");
    }
}
