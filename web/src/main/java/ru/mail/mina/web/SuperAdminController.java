package ru.mail.mina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.mail.mina.service.dto.AdService;
import ru.mail.mina.service.dto.UserService;
import ru.mail.mina.service.model.NewsDTO;
import ru.mail.mina.service.model.UserDTO;

import java.util.List;

/**
 * Created by Администратор on 31.08.2017.
 */

@Controller
public class SuperAdminController {

    private final UserService userService;
    private final AdService adService;

    @Autowired
    public SuperAdminController(UserService userService, AdService adService) {
        this.userService = userService;
        this.adService = adService;
    }

    @RequestMapping(value = "/superadmin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        model.addAttribute("user", new UserDTO());
        return "superAdmin";
    }
}
