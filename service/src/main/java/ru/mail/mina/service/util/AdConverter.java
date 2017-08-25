package ru.mail.mina.service.util;

import ru.mail.mina.repository.model.Ad;
import ru.mail.mina.service.modelDTO.AdDTO;

/**
 * Created by Администратор on 16.08.2017.
 */
public class AdConverter {

    private AdConverter() {

    }

    private static Ad convert(AdDTO adDTO) {
        Ad ad = new Ad();
        ad.setModelAuto(adDTO.getModelAuto());
        ad.setMarkAuto(adDTO.getMarkAuto());

        return ad;
    }

    public static AdDTO convert(Ad ad) {
        AdDTO adDTO = new AdDTO();
//        adDTO.setCarPhotos(ad.getCarPhotos());
        adDTO.setYearOfIssue(ad.getYearOfIssue());
        adDTO.setPrice(ad.getPrice());
        adDTO.setMileAge(ad.getMileAge());
        adDTO.setModelAuto(ad.getModelAuto());
        adDTO.setMarkAuto(ad.getMarkAuto());
        adDTO.setEngine(ad.getEngine());
        adDTO.setCarDescription(ad.getCarDescription());
        return adDTO;
    }
}
