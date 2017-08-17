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
}
