package ru.mail.mina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.mina.repository.dao.AdEntityGenericHibernateDao;
import ru.mail.mina.repository.model.AdEntity;
import ru.mail.mina.service.dto.AdEntityService;

import java.io.File;

/**
 * Created by Администратор on 27.08.2017.
 */
@Service
public class AdEntityServiceImpl implements AdEntityService{


    private final AdEntityGenericHibernateDao genericHibernateDao;

    @Autowired
    public AdEntityServiceImpl(AdEntityGenericHibernateDao genericHibernateDao) {
        this.genericHibernateDao = genericHibernateDao;
    }

    @Override
    @Transactional
    public File getFileById(Long id) {

        AdEntity adEntity = genericHibernateDao.findById(Math.toIntExact(id));
        return new File(adEntity.getFilePath() + adEntity.getFileName());
    }
}
