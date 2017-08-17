package ru.mail.mina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.mail.mina.service.dto.UserService;
import ru.mail.mina.service.modelDTO.UserDTO;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Администратор on 15.08.2017.
 */
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping (value = "/register", method = RequestMethod.GET)
    public String showRegisterBlank(Model model){
        model.addAttribute("user", new UserDTO());
        System.out.println("eeee");
     return "redirect:/#register";
    }

    @RequestMapping (value = "/profile", method = RequestMethod.POST)
    public ModelAndView registerUser (Model model, @ModelAttribute("user")  UserDTO userDTO) {
      //  model.addAttribute("user", new UserDTO());
        userService.saveUser(userDTO);
        System.out.println(userDTO.getLogin());

        return new ModelAndView("/profile");
    }

//    @RequestMapping (value = "/profile", method = RequestMethod.GET)
//    public ModelAndView profileUser (Model model, @ModelAttribute("user")  UserDTO userDTO, HttpServletResponse response) {
//        //  model.addAttribute("user", new UserDTO());
//
//        return new ModelAndView("profile");
//    }
}
