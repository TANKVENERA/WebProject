package ru.mail.mina.web;

import ru.mail.mina.repository.impl.CarPhotosGenericHibernateDaoImpl;
import ru.mail.mina.repository.model.CarPhotos;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 06.08.2017.
 */

public class ImagesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        File f = new File("D:\\photoimages\\" + request.getParameter("foto"));
        System.out.println(request.getParameter("foto"));
        System.out.println("D:\\photoimages\\" + request.getParameter("foto"));
        BufferedImage bi = ImageIO.read(f);
        OutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        out.close();
//            File file = new File("D:\\photoimages" + request.getAttribute("foto"));
//            response.setHeader("Content-Type", getServletContext().getMimeType("D:\\photoimages" + request.getAttribute("foto")));
//            response.setHeader("Content-Length", String.valueOf(file.length()));
//            response.setHeader("Content-Disposition", "inline; filename=\"" + "D:\\photoimages" + request.getAttribute("foto") + "\"");
//            Files.copy(file.toPath(), response.getOutputStream());
//       request.getRequestDispatcher("WEB-INF/pages/images.jsp").forward(request, response);
    }

}