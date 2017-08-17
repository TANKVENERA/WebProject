package ru.mail.mina.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Администратор on 05.08.2017.
 */
@MultipartConfig
public class UploadImage extends HttpServlet {

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("WEB-INF/pages/uploadingPage.jsp").forward(req, resp);
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    String description = req.getParameter("description");
        List<Part> fileParts = req.getParts().stream().collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">
        for (Part filePart : fileParts) {
            String part = filePart.getHeader("content-disposition");
            String fileName = part.substring(part.indexOf('=') + 1).trim().replace("\"", "");
            System.out.println(fileName);
            InputStream fileContent = filePart.getInputStream();
            File fileuploaded = new File("D:\\photoimages");
            File file = new File(fileuploaded, fileName);
            try {
                Files.copy(fileContent, file.toPath());
            } catch (Exception e){
                System.out.println("Error");

            }
        }
        Part partImage = req.getPart("file");
//        System.out.println(partImage.getContentType());
//        String part = partImage.getHeader("content-disposition");
//        System.out.println(partImage.getHeader("content-disposition"));
//        String fileName = part.substring(part.indexOf('=') + 1).trim().replace("\"", "");
//        String finalName = fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
//        InputStream fileData = partImage.getInputStream();
//        File fileuploaded = new File("D:\\photoimages");
//        File file = new File(fileuploaded, finalName);
//        try {
//            Files.copy(fileData, file.toPath());
//        } catch (Exception e){
//            System.out.println("Error");
//
//        }
    }
}
