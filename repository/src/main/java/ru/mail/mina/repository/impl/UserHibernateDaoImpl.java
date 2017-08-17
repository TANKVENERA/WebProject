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

    private Session session;

    private static UserHibernateDaoImpl userHibernateDao = null;

    /*
    Initializing superClass with the type User
     */


    public UserHibernateDaoImpl() {
        super(User.class);
    }

    public static UserHibernateDaoImpl getInstance() {
        if (userHibernateDao == null){
            userHibernateDao = new UserHibernateDaoImpl();
        }
        return userHibernateDao;
    }

    @Override
    public User getUserByAd(Integer adId) {
        User user = null;
        try {
        //    session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "SELECT ad.user  from Ad ad WHERE ad.id=:adId ";
            Query query = session.createQuery(hql);
            query.setParameter("adId", adId); // set a parameter for transfering  adId value into hql query
            user = (User) query.list().get(0);
            session.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
            }
        }

        return user;
    }

    @Override
    public User getByUserName(String login) {
       // session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "From User  u where u.login=:login";
        Query query = session.createQuery(hql);
        query.setParameter("login", login);
        User user = (User) query.uniqueResult();
        return user;
    }
}
