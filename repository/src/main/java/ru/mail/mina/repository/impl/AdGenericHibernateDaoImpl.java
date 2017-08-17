package ru.mail.mina.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.mail.mina.repository.dao.AdGenericHibernateDao;
import ru.mail.mina.repository.model.Ad;



import java.util.List;

/**
 * Created by Администратор on 14.07.2017.
 */
@Repository
public class AdGenericHibernateDaoImpl extends GenericHibernateDaoImpl<Ad, Integer> implements AdGenericHibernateDao {
//    private Session session;
    private static AdGenericHibernateDaoImpl adGenericHibernateDaoImpl = null;

    public AdGenericHibernateDaoImpl() {
        super(Ad.class);
    }

    public static AdGenericHibernateDaoImpl getInstance() {
        if (adGenericHibernateDaoImpl == null) {
            adGenericHibernateDaoImpl = new AdGenericHibernateDaoImpl();
        }
        return adGenericHibernateDaoImpl;
    }

    public List<Ad> filter(String model, String mark, String yearFrom, String yearTo, String priceFrom,
                           String priceTo) {

        Criteria criteria = getSession().createCriteria(Ad.class);
        if (!model.equals("Start")) {
            criteria.add(Restrictions.eq("modelAuto", model));
        }
        if (!mark.equals("Mark")) {
            criteria.add(Restrictions.eq("markAuto", mark));
        }
        if (!yearFrom.isEmpty()) {
            criteria.add(Restrictions.ge("yearOfIssue", Integer.valueOf(yearFrom)));
        }
        if (!yearTo.isEmpty()) {
            criteria.add(Restrictions.le("yearOfIssue", Integer.valueOf(yearTo)));
        }
        if (!priceFrom.isEmpty()) {
            criteria.add(Restrictions.ge("price", Integer.valueOf(priceFrom)));
        }
        if (!priceTo.isEmpty()) {
            criteria.add(Restrictions.le("price", Integer.valueOf(priceTo)));
        }
//        criteria.setFirstResult(0);
//        criteria.setMaxResults(5);
        List<Ad> list = criteria.list();
//        Criteria criteriaCount = session.createCriteria(Ad.class);
//        criteriaCount.setProjection(Projections.rowCount());
//        Long count = (Long) criteriaCount.uniqueResult();
//        session.getTransaction().commit();
        return list;
    }
}
