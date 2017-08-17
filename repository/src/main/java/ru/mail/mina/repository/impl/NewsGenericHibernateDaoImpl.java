package ru.mail.mina.repository.impl;

import ru.mail.mina.repository.dao.NewsGenericHibernateDao;
import ru.mail.mina.repository.model.News;

/**
 * Created by Администратор on 23.07.2017.
 */
public class NewsGenericHibernateDaoImpl extends GenericHibernateDaoImpl<News, Integer> implements NewsGenericHibernateDao {

    public NewsGenericHibernateDaoImpl() {
        super(News.class);
    }
}
