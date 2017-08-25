package ru.mail.mina.repository.impl;

import org.springframework.stereotype.Repository;
import ru.mail.mina.repository.dao.NewsGenericHibernateDao;
import ru.mail.mina.repository.model.News;

/**
 * Created by Администратор on 23.07.2017.
 */
@Repository
public class NewsGenericHibernateDaoImpl extends GenericHibernateDaoImpl<News, Integer> implements NewsGenericHibernateDao {

    public NewsGenericHibernateDaoImpl() {
        super(News.class);
    }
}
