package ru.mail.mina.repository.impl;

import org.springframework.stereotype.Repository;
import ru.mail.mina.repository.dao.NewsEntityGenericHibernateDao;
import ru.mail.mina.repository.model.NewsEntity;

/**
 * Created by Администратор on 20.08.2017.
 */
@Repository
public class NewsEntityGenericHibernateDaoImpl extends GenericHibernateDaoImpl<NewsEntity, Integer> implements NewsEntityGenericHibernateDao {


    public NewsEntityGenericHibernateDaoImpl() {
        super(NewsEntity.class);
    }
}
