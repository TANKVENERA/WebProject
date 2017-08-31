package ru.mail.mina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.mail.mina.service.dto.NewsService;
import ru.mail.mina.service.model.NewsDTO;
import ru.mail.mina.service.model.UserDTO;

import java.util.List;

/**
 * Created by Администратор on 15.08.2017.
 */
@Controller
public class StartPageController {

    private final NewsService newsService;

    @Autowired
    public StartPageController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping( value = {"/", "login"}, method = RequestMethod.GET)
    public String showStartPage(Model model) {
        List<NewsDTO> newsDTOList = newsService.findAll();
        model.addAttribute("user", new UserDTO());
        model.addAttribute("news", newsDTOList);
        return "autosale";
    }
}
