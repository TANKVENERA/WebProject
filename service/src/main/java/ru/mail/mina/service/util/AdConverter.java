package ru.mail.mina.service.util;

import ru.mail.mina.repository.model.Ad;
import ru.mail.mina.service.model.AdDTO;

/**
 * Created by Администратор on 16.08.2017.
 */
public class AdConverter {


    public static Ad convert(AdDTO adDTO) {
        Ad ad = new Ad();
        ad.setDate(adDTO.getDate());
        ad.setId(adDTO.getId());
        ad.setModelAuto(adDTO.getModelAuto());
        ad.setMarkAuto(adDTO.getMarkAuto());
        ad.setYearOfIssue(adDTO.getYearOfIssue());
        ad.setBodyStyle(adDTO.getBodyStyle());
        ad.setCarDescription(adDTO.getCarDescription());
        ad.setPrice(adDTO.getPrice());
        ad.setMileAge(adDTO.getMileAge());
        ad.setEngine(adDTO.getEngine());
        ad.setColor(adDTO.getColor());
        ad.setTransmission(adDTO.getTransmission());
        ad.setAdEntities(adDTO.getAdEntities());
        return ad;
    }

    public static AdDTO convert(Ad ad) {
        AdDTO adDTO = new AdDTO();
        adDTO.setId(ad.getId());
        adDTO.setDate(ad.getDate());
        adDTO.setUser(ad.getUser());
        adDTO.setModelAuto(ad.getModelAuto());
        adDTO.setMarkAuto(ad.getMarkAuto());
        adDTO.setYearOfIssue(ad.getYearOfIssue());
        adDTO.setBodyStyle(ad.getBodyStyle());
        adDTO.setCarDescription(ad.getCarDescription());
        adDTO.setPrice(ad.getPrice());
        adDTO.setMileAge(ad.getMileAge());
        adDTO.setEngine(ad.getEngine());
        adDTO.setColor(ad.getColor());
        adDTO.setTransmission(ad.getTransmission());
        adDTO.setAdEntities(ad.getAdEntities());
        return adDTO;
    }


}
