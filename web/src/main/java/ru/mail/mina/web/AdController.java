package ru.mail.mina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.mail.mina.service.dto.AdService;
import ru.mail.mina.service.model.AdDTO;
import ru.mail.mina.service.model.UserDTO;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        List<AdDTO> listAds = adService.filterAd(model1, mark, yearFrom, yearTo, priceFrom, priceTo);
        return new ModelAndView("selectAds", "listAds", listAds);
    }

    @RequestMapping(value = "/getAllAds", method = RequestMethod.GET)
    public ModelAndView getAllAds(Model model) {
        model.addAttribute("user", new UserDTO());
        List<AdDTO> listAds = adService.findAll();
        return new ModelAndView("selectAds", "listAds", listAds);
    }

    @RequestMapping(value = "/userAds", method = RequestMethod.GET)
    public ModelAndView getUserAds(Model model) {
        model.addAttribute("user", new UserDTO());
        List<AdDTO> userAds = adService.getAdsByUser();
        return new ModelAndView("userAds", "userAds", userAds);
    }

    @RequestMapping(value = "/deleteAd/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAd(Model model, @PathVariable Integer id) {
        model.addAttribute("user", new UserDTO());
        adService.deleteAd(id);
        return new ModelAndView("redirect:/userAds");
    }

    @RequestMapping(value = "/updateAd", method = RequestMethod.POST)
    public String updateUserAd (@ModelAttribute ("userAd") AdDTO adDTO, HttpServletRequest request, Model model) throws IOException {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm");
        adDTO.setCarDescription(request.getParameter("text"));
        Date date = new Date();
        model.addAttribute("user", new UserDTO());
        adService.updateAd(adDTO);
        return "profile";
    }

    @RequestMapping(value = "/ad/{id}" , method = RequestMethod.GET)
    public String showUserAd(Model model, @PathVariable Integer id){
        AdDTO adDTO = adService.getById(id);
        model.addAttribute("user", new UserDTO());
        model.addAttribute("userAd", adDTO);
        return "updateAd";
    }

    @RequestMapping (value = "/createAd", method = RequestMethod.POST)
    public String createAd(Model model, @ModelAttribute ("ad")AdDTO adDTO, HttpServletRequest request) throws IOException {
        model.addAttribute("user", new UserDTO());
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm");
        Date date = new Date();
        adDTO.setDate(format.format(date));
        adDTO.setCarDescription(request.getParameter("carDescription"));
        adService.saveAd(adDTO);
        return "redirect:/userAds";
    }

}
