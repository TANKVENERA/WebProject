package ru.mail.mina.web;

import org.hibernate.Hibernate;
import ru.mail.mina.repository.impl.AdGenericHibernateDaoImpl;
import ru.mail.mina.repository.impl.CarPhotosGenericHibernateDaoImpl;
import ru.mail.mina.repository.model.Ad;
import ru.mail.mina.repository.model.CarPhotos;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 29.07.2017.
 */
public class AutoSaleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/pages/autosale.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        CarPhotosGenericHibernateDaoImpl carPhotosGenericHibernateDao = new CarPhotosGenericHibernateDaoImpl();
//        List<CarPhotos> carPhotos = carPhotosGenericHibernateDao.findAll();
//        req.setAttribute("carPhotos", carPhotos);

        String model = req.getParameter("CarModel");
        String mark = req.getParameter("CarMark");
        String yearFrom = req.getParameter("YearOfIssueFrom");
        String yearTo = req.getParameter("YearOfIssueTo");
        String priceFrom = req.getParameter("PriceFrom");
        String priceTo = req.getParameter("PriceTo");
        System.out.println(model);
        System.out.println(mark);
        AdGenericHibernateDaoImpl adGenericHibernateDao = AdGenericHibernateDaoImpl.getInstance();
       List<Ad> listAds = adGenericHibernateDao.filter(model, mark, yearFrom, yearTo, priceFrom, priceTo);
        System.out.println(listAds);
        req.setAttribute("listAds", listAds);
        req.getRequestDispatcher("WEB-INF/pages/selectAds.jsp").forward(req, resp);
        }
    }

