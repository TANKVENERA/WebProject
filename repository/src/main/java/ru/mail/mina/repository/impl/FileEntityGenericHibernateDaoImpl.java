package ru.mail.mina.repository.impl;

import org.springframework.stereotype.Repository;
import ru.mail.mina.repository.dao.FileEntityGenericHibernateDao;
import ru.mail.mina.repository.model.FileEntity;

/**
 * Created by Администратор on 20.08.2017.
 */
@Repository
public class FileEntityGenericHibernateDaoImpl extends GenericHibernateDaoImpl<FileEntity, Integer> implements FileEntityGenericHibernateDao {


    public FileEntityGenericHibernateDaoImpl() {
        super(FileEntity.class);
    }
}
