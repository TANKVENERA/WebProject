package ru.mail.mina.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.mail.mina.service.model.UserDTO;



/**
 * Created by Администратор on 31.08.2017.
 */

@Controller
public class SuperAdminController {

    @RequestMapping(value = "/superadmin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        model.addAttribute("user", new UserDTO());
        return "superAdmin";
    }
}
