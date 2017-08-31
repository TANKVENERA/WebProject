package ru.mail.mina.service.util;

import ru.mail.mina.repository.model.Basket;
import ru.mail.mina.service.model.BasketDTO;

/**
 * Created by Администратор on 29.08.2017.
 */
public class BasketConverter {

    public static BasketDTO convert(Basket basket) {
        BasketDTO basketDTO = new BasketDTO();
        basketDTO.setId(basket.getId());
        basketDTO.setAd(basket.getAd());
        return basketDTO;
    }
}
