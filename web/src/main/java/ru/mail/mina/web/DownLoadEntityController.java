package ru.mail.mina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mail.mina.service.dto.AdEntityService;
import ru.mail.mina.service.dto.NewsEntityService;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * Created by Администратор on 29.08.2017.
 */

@Controller
public class DownLoadEntityController {


    private final AdEntityService adEntityService;
    private final NewsEntityService newsEntityService;

    @Autowired
    public DownLoadEntityController(AdEntityService adEntityService, NewsEntityService newsEntityService) {
        this.adEntityService = adEntityService;
        this.newsEntityService = newsEntityService;
    }

    @RequestMapping(value = "/downloadEntity/{id}", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response, @PathVariable Long id, @RequestParam String type) throws IOException {
        File file;
        if (type.equals("ad")) {
            file = adEntityService.getFileById(id);
        } else {
            file = newsEntityService.getFileById(id);
        }
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
