package ru.mail.mina.repository.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Администратор on 12.07.2017.
 */
public interface GenericHibernateDao<T extends Serializable, ID extends Serializable> {

    ID insert(T entity); //saveOrUpdate, delete All

    void update(T entity);

    void saveOrUpdate(T entity);

    void delete( ID id);

    List<T> findAll();

   T findById(ID id);

}
