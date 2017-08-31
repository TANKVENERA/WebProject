package ru.mail.mina.repository.dao;

import ru.mail.mina.repository.model.Ad;
import ru.mail.mina.repository.model.Basket;

import java.util.List;

/**
 * Created by Администратор on 21.07.2017.
 */
public interface BasketGenericHibernateDao extends GenericHibernateDao<Basket, Integer> {

    List<Ad> getAll (Integer loggedUserId);

    void deleteAdFromBasket (Integer adId, Integer loggedUserId);

}
