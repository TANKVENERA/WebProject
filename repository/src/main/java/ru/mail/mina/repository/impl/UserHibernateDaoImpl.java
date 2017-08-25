package ru.mail.mina.repository.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.mina.repository.dao.UserGenericHibernateDao;
import ru.mail.mina.repository.model.User;


import java.util.List;


/**
 * Created by Администратор on 13.07.2017.
 */

@Repository("userDao")
public class UserHibernateDaoImpl extends GenericHibernateDaoImpl<User, Integer> implements UserGenericHibernateDao {

    /**
    Initializing superClass with the type User
     */
    public UserHibernateDaoImpl() {
        super(User.class);
    }


    @Override
    @Transactional
    public User getUserByAd(Integer adId) {
        User user = null;
        try {
            getSession().beginTransaction();
            String hql = "SELECT ad.user  from Ad ad WHERE ad.id=:adId ";
            Query query =  getSession().createQuery(hql);
            query.setParameter("adId", adId); // set a parameter for transfering  adId value into hql query
            user = (User) query.list().get(0);
            getSession().getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if ( getSession() != null &&  getSession().isOpen()) {
            }
        }
        return user;
    }

    @Override
    @Transactional
    public User getByUserName(String username) {
        String hql = "From User  u where u.username=:username";
        Query query =  getSession().createQuery(hql);
        query.setParameter("username", username);
        User user = (User) query.uniqueResult();
        return user;
    }
}
