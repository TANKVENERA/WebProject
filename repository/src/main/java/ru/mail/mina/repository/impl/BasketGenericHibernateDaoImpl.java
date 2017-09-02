package ru.mail.mina.repository.impl;


import org.springframework.stereotype.Repository;
import ru.mail.mina.repository.dao.BasketGenericHibernateDao;
import ru.mail.mina.repository.model.Ad;
import ru.mail.mina.repository.model.Basket;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Администратор on 21.07.2017.
 */
@Repository
public class BasketGenericHibernateDaoImpl extends GenericHibernateDaoImpl<Basket, Integer> implements BasketGenericHibernateDao {

    public BasketGenericHibernateDaoImpl() {
        super(Basket.class);
    }


    @Override
    public List<Ad> getAll(Integer loggedUserId) {
        List<Ad> list = null;
        try {
            String hql = "SELECT b.ad from Basket b WHERE b.loggedUserId=:loggedUserId ";
            Query query = getSession().createQuery(hql);
            query.setParameter("loggedUserId", loggedUserId);
            list = query.getResultList();
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public void deleteAdFromBasket(Integer adId, Integer loggedUserId) {
        Basket basket = null;
        try {
            String hql = "DELETE   from Basket  b   WHERE b.loggedUserId=:loggedUserId and b.ad.id=:adId ";
            Query query = getSession().createQuery(hql);
            query.setParameter("loggedUserId", loggedUserId);
            query.setParameter("adId", adId);
            int deleteResult = query.executeUpdate();
        } catch (Exception e) {
        }
    }
}
