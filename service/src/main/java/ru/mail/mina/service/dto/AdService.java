package ru.mail.mina.service.dto;

import org.springframework.stereotype.Service;
import ru.mail.mina.repository.model.Ad;

import java.util.List;

/**
 * Created by Администратор on 16.08.2017.
 */
@Service
public interface AdService {

    List<Ad> filterAd(String model, String mark, String yearFrom, String yearTo, String priceFrom,
                     String priceTo);
}
