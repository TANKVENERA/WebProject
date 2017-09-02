package ru.mail.mina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mail.mina.service.dto.NewsService;
import ru.mail.mina.service.model.NewsDTO;
import ru.mail.mina.service.model.UserDTO;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Администратор on 20.08.2017.
 */
@Controller
public class AdminController {

    private final NewsService newsService;


    @Autowired
    public AdminController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("news", new NewsDTO());
        List<NewsDTO> newsDTOList = newsService.findAll();
        model.addAttribute("n", newsDTOList);
        return "administrator";
    }

    @RequestMapping(value = "/uploadNews", method = RequestMethod.POST)
    public String updateNews(@ModelAttribute("news") NewsDTO newsDTO, Model model, HttpServletRequest request,
                             @RequestParam (required=false , value = "save") String saveFlag,
                             @RequestParam (required=false , value = "update") String updateFlag,
                             @RequestParam (required=false , value = "delete") String deleteFlag) throws IOException {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm");
        Date date = new Date();
        newsDTO.setText(request.getParameter("text"));
        model.addAttribute("user", new UserDTO());
        if (saveFlag!=null) {
            newsDTO.setDate(format.format(date));
            newsService.saveNews(newsDTO);
        }
        else if (updateFlag!=null) {
            newsService.update(newsDTO);
        }
        else if (deleteFlag!=null) {
            newsService.delete(newsDTO.getId());
        }
        return "redirect:/admin";
    }

    @RequestMapping (value = {"/allNews"}, method = RequestMethod.GET)
    public String showAllNews(Model model){
        model.addAttribute("user", new UserDTO());
        List<NewsDTO> newsDTOList = newsService.findAll();
        model.addAttribute("news", newsDTOList);
        return "allNews";
    }
}
