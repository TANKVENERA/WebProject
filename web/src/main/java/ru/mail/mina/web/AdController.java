package ru.mail.mina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.mail.mina.repository.model.Ad;
import ru.mail.mina.service.dto.AdService;
import ru.mail.mina.service.implDTO.AdServiceImpl;
import ru.mail.mina.service.modelDTO.UserDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Администратор on 15.08.2017.
 */
@Controller
public class AdController {

    private final AdService adService;

    @Autowired
    public AdController(AdService adService) {
        this.adService = adService;
    }

    @RequestMapping (value = "/selectAds", method = RequestMethod.POST)
    public ModelAndView filterAds(HttpServletRequest request, Model model) {
       model.addAttribute("user", new UserDTO());
        String model1 = request.getParameter("CarModel");
        String mark = request.getParameter("CarMark");
        String yearFrom = request.getParameter("YearOfIssueFrom");
        String yearTo = request.getParameter("YearOfIssueTo");
        String priceFrom = request.getParameter("PriceFrom");
        String priceTo = request.getParameter("PriceTo");

//        System.out.println(model);
//        System.out.println(mark);
//        System.out.println(yearFrom);
//        System.out.println(yearTo);
//        System.out.println(priceFrom);
//        System.out.println(priceTo);
       List<Ad> listAds = adService.filterAd(model1, mark, yearFrom, yearTo, priceFrom, priceTo);
        return new ModelAndView("selectAds", "listAds", listAds);
    }
}
