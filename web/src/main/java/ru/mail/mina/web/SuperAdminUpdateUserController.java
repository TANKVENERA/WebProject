package ru.mail.mina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mail.mina.service.dto.UserService;
import ru.mail.mina.service.model.NewsDTO;
import ru.mail.mina.service.model.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.xml.soap.SOAPPart;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Администратор on 31.08.2017.
 */
@Controller
public class SuperAdminUpdateUserController {

    private final UserService userService;

    @Autowired
    public SuperAdminUpdateUserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public String geAllUsers (Model model) {
        model.addAttribute("user", new UserDTO());
        List<UserDTO> userDTOS = userService.findAll();
        model.addAttribute("userDTOS", userDTOS);
        return "adminUpdUser";
    }

    @RequestMapping(value = "/getUserByID", method = RequestMethod.POST)
    public String getUSerById ( Model model, @RequestParam("getUserByID") Integer id) {
        model.addAttribute("user", new UserDTO());
        List<UserDTO> userDTOS = new ArrayList<>(1);
        userDTOS.add(userService.getUserById(id));
        model.addAttribute("userDTOS", userDTOS);
        return "adminUpdUser";
    }

    @RequestMapping(value = "/getUserByName", method = RequestMethod.POST)
    public String getUserByUserName ( Model model, @RequestParam("getUserByName") String name) {
        model.addAttribute("user", new UserDTO());
        List<UserDTO> userDTOS = new ArrayList<>(1);
        userDTOS.add(userService.getByUserName(name));
        model.addAttribute("userDTOS", userDTOS);
        return "adminUpdUser";
    }

    @RequestMapping(value = "/updateUserByAdmin", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") UserDTO userDTO, Model model,
                             @RequestParam (required=false , value = "save") String saveFlag,
                             @RequestParam (required=false , value = "update") String updateFlag,
                             @RequestParam (required=false , value = "delete") String deleteFlag) throws IOException {
        if (saveFlag!=null) {
            userService.saveUser(userDTO);
        }
        else if (updateFlag!=null) {
            userService.update(userDTO);
        }
        else if (deleteFlag!=null) {
           userService.deleteUser(userDTO.getId());
        }
        return "redirect:/getAllUsers";
    }
}
