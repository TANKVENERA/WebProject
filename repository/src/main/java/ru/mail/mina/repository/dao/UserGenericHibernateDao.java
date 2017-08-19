package ru.mail.mina.repository.dao;

import ru.mail.mina.repository.model.User;

/**
 * Created by Администратор on 12.07.2017.
 */
public interface UserGenericHibernateDao extends GenericHibernateDao<User, Integer> {

   User getUserByAd (Integer adId);

   User getByUserName(String username);
}
