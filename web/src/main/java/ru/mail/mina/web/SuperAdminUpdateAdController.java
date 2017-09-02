package ru.mail.mina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mail.mina.service.dto.AdService;
import ru.mail.mina.service.model.AdDTO;
import ru.mail.mina.service.model.UserDTO;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Администратор on 31.08.2017.
 */

@Controller
public class SuperAdminUpdateAdController {

    private final AdService adService;


    @Autowired
    public SuperAdminUpdateAdController(AdService adService) {
        this.adService = adService;
    }


    @RequestMapping(value = "/allAdsByAdmin", method = RequestMethod.GET)
    public String getAllAds(Model model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("ads", new AdDTO());
        List<AdDTO> listAds = adService.findAll();
        model.addAttribute("listAds", listAds);
        return "adminUpdAd";
    }

    @RequestMapping(value = "/allAdsByID", method = RequestMethod.POST)
    public String getAdById ( Model model, @RequestParam("getAdById") Integer id) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("ads", new AdDTO());
        List<AdDTO> listAds = new ArrayList<>(1);
        listAds.add(adService.getById(id));
        model.addAttribute("listAds", listAds);
        return "adminUpdAd";
    }

    @RequestMapping(value = "/allAdsByName", method = RequestMethod.POST)
    public String getAdByName ( Model model, @RequestParam("getAdByUsername") String name) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("ads", new AdDTO());
        List<AdDTO> listAds = adService.getAdsByUserName(name);
        model.addAttribute("listAds", listAds);
        return "adminUpdAd";
    }

    @RequestMapping(value = "/updateAdByAdmin", method = RequestMethod.POST)
    public String updateAd(@ModelAttribute("ads") AdDTO adDTO, Model model, HttpServletRequest request,
                             @RequestParam (required=false , value = "save") String saveFlag,
                             @RequestParam (required=false , value = "update") String updateFlag,
                             @RequestParam (required=false , value = "delete") String deleteFlag) throws IOException {
        adDTO.setCarDescription(request.getParameter("carDescription"));
        if (saveFlag!=null) {
            DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm");
            Date date = new Date();
            adDTO.setDate(format.format(date));
            adService.saveAd(adDTO);
        }
        else if (updateFlag!=null) {
           adService.updateAd(adDTO);
        }
        else if (deleteFlag!=null) {
            adService.deleteAd(adDTO.getId());
        }
        return "redirect:/allAdsByAdmin";
    }
}
