package ru.mail.mina.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.mail.mina.service.dto.BasketService;
import ru.mail.mina.service.model.AdDTO;
import ru.mail.mina.service.model.UserDTO;

import java.util.List;

/**
 * Created by Администратор on 29.08.2017.
 */

@Controller
public class BasketController {

    private final BasketService basketService;

    @Autowired
    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @RequestMapping(value = "/addToBasket/{id}", method = RequestMethod.GET)
    public String addAdToBasket(Model model, @PathVariable ("id") Integer id){
        model.addAttribute("user", new UserDTO());
        basketService.insertAd(id);
        return "redirect:/notes";
    }

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public String getAllAds(Model model){
        List<AdDTO> adDTOList = basketService.findAll();
        model.addAttribute("userAds", adDTOList);
        model.addAttribute("user", new UserDTO());
        return "basketAds"; // возвращает ту же страницу , но с данными корзины
    }

    @RequestMapping(value = "/deleteAdFromBasket/{id}", method = RequestMethod.GET)
    public String deleteAdFromBasket (Model model, @PathVariable ("id") Integer id) {
        model.addAttribute("user", new UserDTO());

        basketService.deleteAd(id);
        return "redirect:/notes";
    }
}
