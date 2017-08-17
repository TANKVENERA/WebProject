package ru.mail.mina.repository.dao;


import ru.mail.mina.repository.model.Ad;

import java.util.List;

/**
 * Created by Администратор on 12.07.2017.
 */
public interface AdGenericHibernateDao extends GenericHibernateDao<Ad, Integer> {

        List<Ad> filter (String model, String mark, String yearFrom, String yearTo, String priceFrom,
                         String priceTo);
}
