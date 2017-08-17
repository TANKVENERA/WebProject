package ru.mail.mina.service.implDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mail.mina.repository.dao.AdGenericHibernateDao;
import ru.mail.mina.repository.impl.AdGenericHibernateDaoImpl;
import ru.mail.mina.repository.model.Ad;
import ru.mail.mina.service.dto.AdService;

import java.util.List;

/**
 * Created by Администратор on 16.08.2017.
 */
@Service("AdService")
public class AdServiceImpl implements AdService {

    private final AdGenericHibernateDao adGenericHibernateDao;

    @Autowired
    public AdServiceImpl(AdGenericHibernateDao adGenericHibernateDao) {
        this.adGenericHibernateDao = adGenericHibernateDao;
    }

    @Override
    public List<Ad> filterAd(String model, String mark, String yearFrom, String yearTo, String priceFrom, String priceTo) {

        return adGenericHibernateDao.filter(model, mark, yearFrom, yearTo, priceFrom, priceTo);
    }


}
