package ru.mail.mina.service.implDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.mina.repository.dao.AdGenericHibernateDao;
import ru.mail.mina.repository.impl.AdGenericHibernateDaoImpl;
import ru.mail.mina.repository.model.Ad;
import ru.mail.mina.service.dto.AdService;
import ru.mail.mina.service.modelDTO.AdDTO;
import ru.mail.mina.service.util.AdConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 16.08.2017.
 */
@Service
public class AdServiceImpl implements AdService {

    private final AdGenericHibernateDao adGenericHibernateDao;

    @Autowired
    public AdServiceImpl(AdGenericHibernateDao adGenericHibernateDao) {
        this.adGenericHibernateDao = adGenericHibernateDao;
    }

    @Override
    @Transactional
    public List<AdDTO> filterAd(String model, String mark, String yearFrom, String yearTo, String priceFrom, String priceTo) {
        List<AdDTO> adDTOList = new ArrayList<>();
        List<Ad> list = adGenericHibernateDao.filter(model, mark, yearFrom, yearTo, priceFrom, priceTo);
        for (Ad element : list) {
            AdDTO adDTO = AdConverter.convert(element);
            adDTOList.add(adDTO);
        }

        return adDTOList;
    }

    @Override
    @Transactional
    public List<AdDTO> findAll() {
        List<AdDTO> adDTOList = new ArrayList<>();
        List<Ad> list = adGenericHibernateDao.findAll();
        for (Ad element : list) {
            AdDTO adDTO = AdConverter.convert(element);
            adDTOList.add(adDTO);
        }
        return adDTOList;
    }
}
