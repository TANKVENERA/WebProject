package ru.mail.mina.service.implDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.mina.repository.dao.FileEntityGenericHibernateDao;
import ru.mail.mina.repository.model.FileEntity;
import ru.mail.mina.service.dto.FileEntityService;

import java.io.File;

/**
 * Created by Администратор on 20.08.2017.
 */
@Service
public class FileEntityServiceImpl implements FileEntityService {

    @Autowired
    private final FileEntityGenericHibernateDao genericHibernateDao;

    public FileEntityServiceImpl(FileEntityGenericHibernateDao genericHibernateDao) {
        this.genericHibernateDao = genericHibernateDao;
    }

    @Override
    @Transactional
    public File getFileById(Long id) {
        FileEntity fileEntity = genericHibernateDao.findById(Math.toIntExact(id));
        System.out.println(fileEntity);
        return new File(fileEntity.getFilePath() + fileEntity.getFileName());
    }
}
