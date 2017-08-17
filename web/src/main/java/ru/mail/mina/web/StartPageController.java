package ru.mail.mina.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.mail.mina.service.modelDTO.UserDTO;

/**
 * Created by Администратор on 15.08.2017.
 */
@Controller
public class StartPageController {

    @RequestMapping( value = {"/"}, method = RequestMethod.GET)
    public String showStartPage(Model model) {
    model.addAttribute("user", new UserDTO());
        System.out.println("hi");
        return "autosale";
    }
}
