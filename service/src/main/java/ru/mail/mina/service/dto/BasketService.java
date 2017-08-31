package ru.mail.mina.service.dto;

import ru.mail.mina.service.model.AdDTO;
import ru.mail.mina.service.model.BasketDTO;

import java.util.List;

/**
 * Created by Администратор on 29.08.2017.
 */
public interface BasketService {

    void deleteAd(Integer adId);

    void insertAd(Integer adId);

    List<AdDTO> findAll();
}
