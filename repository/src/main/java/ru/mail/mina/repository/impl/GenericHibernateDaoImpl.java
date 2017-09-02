package ru.mail.mina.repository.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mail.mina.repository.dao.GenericHibernateDao;
import java.io.Serializable;
import java.util.List;


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
        return this.sessionFactory.getCurrentSession();
    }


    @Override
    public ID insert(T entity) {
        return (ID) getSession().save(entity);
    }

    @Override
    public void update(T entity) {
        try {
            getSession().update(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    /*here the variable clazz should be instantiated with the help of calling superconstructor
         * in the overridden classes  */
    @Override
    public void delete(ID id) {
        try {
            T t = (T) getSession().get(clazz, id);
            getSession().delete(t);
        } catch (Exception e) {
        }
    }

    @Override
    public List<T> findAll() {
        List<T> list = null;
        try {
            list = getSession().createCriteria(clazz).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public T findById(ID id) {
        T t = null;
        try {
            t = (T) getSession().get(clazz, id);
            getSession().evict(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
