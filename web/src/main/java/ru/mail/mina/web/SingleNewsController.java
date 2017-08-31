package ru.mail.mina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.mail.mina.service.dto.NewsService;
import ru.mail.mina.service.model.NewsDTO;
import ru.mail.mina.service.model.UserDTO;

/**
 * Created by Администратор on 29.08.2017.
 */
@Controller
public class SingleNewsController {

    private final NewsService newsService;

    @Autowired
    public SingleNewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping( value = "/news/{id}", method = RequestMethod.GET)
    public String showSingleIssue (Model model, @PathVariable Integer id) {
        NewsDTO newsDTO = newsService.getById(id);
        model.addAttribute("issue", newsDTO);
        model.addAttribute("user", new UserDTO());
        return "news";
        }
}
