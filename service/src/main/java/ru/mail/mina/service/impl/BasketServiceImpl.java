package ru.mail.mina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.mina.repository.dao.AdGenericHibernateDao;
import ru.mail.mina.repository.dao.BasketGenericHibernateDao;
import ru.mail.mina.repository.dao.UserGenericHibernateDao;
import ru.mail.mina.repository.model.Ad;
import ru.mail.mina.repository.model.Basket;
import ru.mail.mina.repository.model.User;
import ru.mail.mina.service.dto.BasketService;
import ru.mail.mina.service.model.AdDTO;
import ru.mail.mina.service.model.AppUserPrincipal;
import ru.mail.mina.service.util.AdConverter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 29.08.2017.
 */
@Service
public class BasketServiceImpl implements BasketService {

    private final BasketGenericHibernateDao basketGenericHibernateDao;
    private final AdGenericHibernateDao adGenericHibernateDao;
    private final UserGenericHibernateDao userGenericHibernateDao;

    @Autowired
    public BasketServiceImpl(BasketGenericHibernateDao basketGenericHibernateDao,
                             AdGenericHibernateDao adGenericHibernateDao,
                             UserGenericHibernateDao userGenericHibernateDao) {
        this.basketGenericHibernateDao = basketGenericHibernateDao;
        this.adGenericHibernateDao = adGenericHibernateDao;
        this.userGenericHibernateDao = userGenericHibernateDao;
    }

    @Override
    @Transactional
    public void deleteAd(Integer adId) {
        System.out.println("=========================================");
        Integer loggedUserId = getUser().getId();
        System.out.println(loggedUserId);
        basketGenericHibernateDao.deleteAdFromBasket(adId, loggedUserId);
    }

    @Override
    @Transactional
    public void insertAd(Integer adId) {
        Ad ad = adGenericHibernateDao.findById(adId);
        Basket basket = new Basket();
        basket.setAd(ad);
        basket.setLoggedUserId(getUser().getId());
        basketGenericHibernateDao.insert(basket);
    }


    @Override
    @Transactional
    public List<AdDTO> findAll() {
        List<Ad> adList = basketGenericHibernateDao.getAll(getUser().getId());
        List<AdDTO> adDTOList = new ArrayList<>();
        for (Ad ad : adList) {
            adDTOList.add(AdConverter.convert(ad));
        }
        return adDTOList;
    }

    private User getUser() {
        AppUserPrincipal principal = (AppUserPrincipal) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return userGenericHibernateDao.findById(principal.getUserId());
    }
}
