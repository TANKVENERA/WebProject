package ru.mail.mina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.mina.repository.dao.NewsEntityGenericHibernateDao;
import ru.mail.mina.repository.model.NewsEntity;
import ru.mail.mina.service.dto.NewsEntityService;

import java.io.File;

/**
 * Created by Администратор on 20.08.2017.
 */
@Service
public class NewsEntityServiceImpl implements NewsEntityService {

    @Autowired
    private final NewsEntityGenericHibernateDao genericHibernateDao;

    public NewsEntityServiceImpl(NewsEntityGenericHibernateDao genericHibernateDao) {
        this.genericHibernateDao = genericHibernateDao;
    }

    @Override
    @Transactional
    public File getFileById(Long id) {
        NewsEntity newsEntity = genericHibernateDao.findById(Math.toIntExact(id));
        return new File(newsEntity.getFilePath() + newsEntity.getFileName());
    }

}
