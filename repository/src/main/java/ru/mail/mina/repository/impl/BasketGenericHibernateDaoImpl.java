package ru.mail.mina.repository.impl;

import org.springframework.stereotype.Repository;
import ru.mail.mina.repository.dao.BasketGenericHibernateDao;
import ru.mail.mina.repository.model.Basket;

/**
 * Created by Администратор on 21.07.2017.
 */
@Repository
public class BasketGenericHibernateDaoImpl extends GenericHibernateDaoImpl<Basket, Integer> implements BasketGenericHibernateDao {

    public BasketGenericHibernateDaoImpl() {
        super(Basket.class);
    }
}
