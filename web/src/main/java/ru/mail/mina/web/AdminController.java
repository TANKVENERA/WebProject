package ru.mail.mina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.mail.mina.repository.model.FileEntity;
import ru.mail.mina.service.dto.AdService;
import ru.mail.mina.service.dto.FileEntityService;
import ru.mail.mina.service.dto.NewsService;
import ru.mail.mina.service.dto.UserService;
import ru.mail.mina.service.modelDTO.NewsDTO;
import ru.mail.mina.service.modelDTO.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;
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
    private final FileEntityService fileService;


    @Autowired
    public AdminController(NewsService newsService, FileEntityService fileService) {
        this.newsService = newsService;
        this.fileService = fileService;
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
        return "administrator";
    }

    @RequestMapping (value = {"/allNews"}, method = RequestMethod.GET)
    public String showAllNews(Model model){
        model.addAttribute("user", new UserDTO());
        List<NewsDTO> newsDTOList = newsService.findAll();
        model.addAttribute("news", newsDTOList);
        return "allNews";
    }

    @RequestMapping(value = "/downloadNews/{id}", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response, @PathVariable Long id) throws IOException {
        File file = fileService.getFileById(id);
        if (!file.exists()) {
            String errorMessage = "The file you are looking for does not exist";
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }

        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("inline; filename=\"%s\"", file.getName()));
        response.setContentLength((int) file.length());

        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStream inputStream = new BufferedInputStream(fileInputStream)
        ) {
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        }
    }
}
