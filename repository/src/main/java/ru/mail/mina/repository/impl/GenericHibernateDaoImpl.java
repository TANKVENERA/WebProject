package ru.mail.mina.repository.impl;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.mina.repository.dao.GenericHibernateDao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Администратор on 13.07.2017.
 */

@Repository
public abstract class GenericHibernateDaoImpl<T extends Serializable, ID extends Serializable> implements GenericHibernateDao<T, ID> {

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T> clazz;


    public GenericHibernateDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    protected Session getSession() {
        return this.sessionFactory.openSession();
    }


    @Override

    public ID insert(T entity) {
        return (ID) getSession().save(entity);
    }

    @Override
    public void update(T entity) {
        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            session.update(entity);
//            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
        }
    }

    /*here the variable clazz should be instantiated with the help of calling superconstructor
     * in the overridden classes  */
    @Override
    public void delete(ID id) {
        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            T t = (T) session.get(clazz, id);
//            session.delete(t);
//            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
        }
    }

    @Override
    public List<T> findAll() {
        List<T> list = null;
        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            list = session.createCriteria(clazz).list();
//            //  Query query = session.createQuery(hql);
//            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
        }
        return list;
    }

    @Override
    public T findById(ID id) {
        T t = null;
        try {
//            session = HibernateUtil.getSessionFactory().getCurrentSession();
//            session.beginTransaction();
//            t = (T) session.get(clazz, id);
//            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
        }

        return t;
    }
}
