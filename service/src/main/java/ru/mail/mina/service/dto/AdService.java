package ru.mail.mina.service.dto;

import org.springframework.stereotype.Service;
import ru.mail.mina.repository.model.Ad;
import ru.mail.mina.service.model.AdDTO;

import java.io.IOException;
import java.util.List;

/**
 * Created by Администратор on 16.08.2017.
 */
@Service
public interface AdService {

    List<AdDTO> filterAd(String model, String mark, String yearFrom, String yearTo, String priceFrom,
                         String priceTo);

    List<AdDTO> findAll();

    void saveAd(AdDTO adDTO) throws IOException;

    AdDTO getById (Integer id);

    List<AdDTO> getAdsByUser();

    void deleteAd(Integer id);

    void updateAd(AdDTO adDTO) throws IOException;

    List<AdDTO> getAdsByUserName(String userName);

}
