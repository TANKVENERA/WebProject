package ru.mail.mina.service.implDTO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import ru.mail.mina.repository.dao.NewsGenericHibernateDao;
import ru.mail.mina.repository.dao.UserGenericHibernateDao;
import ru.mail.mina.repository.impl.NewsGenericHibernateDaoImpl;
import ru.mail.mina.repository.model.FileEntity;
import ru.mail.mina.repository.model.News;
import ru.mail.mina.repository.model.User;
import ru.mail.mina.service.dto.NewsService;
import ru.mail.mina.service.modelDTO.AppUserPrincipal;
import ru.mail.mina.service.modelDTO.NewsDTO;
import ru.mail.mina.service.util.NewsConverter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Администратор on 20.08.2017.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private final NewsGenericHibernateDao newsGenericHibernateDao;

    @Autowired
    private Environment environment;

    @Autowired
    private final UserGenericHibernateDao userGenericHibernateDao;



    public NewsServiceImpl(NewsGenericHibernateDao newsgenericHibernateDao, UserGenericHibernateDao userGenericHibernateDao) {
        this.newsGenericHibernateDao = newsgenericHibernateDao;
        this.userGenericHibernateDao = userGenericHibernateDao;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        newsGenericHibernateDao.delete(id);
    }

    @Override
    @Transactional
    public List<NewsDTO> findAll() {
        List<News> newsList = newsGenericHibernateDao.findAll();
        List<NewsDTO> newsDTOList = new ArrayList<>();
        for (News news : newsList) {
            NewsDTO newsDTO = NewsConverter.convert(news);
            newsDTOList.add(newsDTO);
        }
        return newsDTOList;
    }

    private User getUser() {
        AppUserPrincipal principal = (AppUserPrincipal) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return userGenericHibernateDao.findById(principal.getUserId());
    }

    @Override
   @Transactional
    public void saveNews(NewsDTO newsDTO) throws IOException {
        News news = NewsConverter.convert(newsDTO); // внесение  текста новости в news
        User user = getUser();
        try {
            FileEntity fileEntity = getFileEntity(newsDTO);
            news.setFileEntity(fileEntity); // внесение файла в news
            news.setFk_User(user.getId());
          newsGenericHibernateDao.insert(news); // updating user and saving all extended entities by cascade
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public void update(NewsDTO newsDTO) throws IOException {
        News news = NewsConverter.convert(newsDTO); // внесение  текста новости в news
        User user = getUser();
        try {
            FileEntity fileEntity = getFileEntity(newsDTO);
            news.setFileEntity(fileEntity); // внесение файла в news
            news.setFk_User(user.getId());
            news.setDate(getById(newsDTO.getId()).getDate());
            newsGenericHibernateDao.update(news); // updating user and saving all extended entities by cascade
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public void saveOrUpdate(NewsDTO newsDTO) throws IOException {
        News news = NewsConverter.convert(newsDTO);
        User user = getUser();
        try {
            FileEntity fileEntity = getFileEntity(newsDTO);
            news.setFileEntity(fileEntity); // внесение файла в news
      newsGenericHibernateDao.saveOrUpdate(news); // updating user and saving all extended entities by cascade
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public News getById(Integer id) {
      return   newsGenericHibernateDao.findById(id);
    }

    private FileEntity getFileEntity(NewsDTO newsDTO) throws IOException {
        String finalPath;
        String fileName = newsDTO.getDate()== null ? getById(newsDTO.getId()).getDate() : newsDTO.getDate();
        String fileLocation = environment.getProperty("upload.location")  + fileName + "\\";
        File file = new File(fileLocation );
        if (!file.exists()){
            file.mkdirs();
            finalPath = fileLocation + fileName;
            FileCopyUtils.copy(newsDTO.getFile().getBytes(), new File(finalPath)); // из переменной MultiPartFile file извлекается картинка
            FileEntity  fileEntity  = new FileEntity();
            fileEntity.setFilePath(fileLocation);
            fileEntity.setFileName(fileName);
            return fileEntity;
        } else {
           FileEntity fileEntity = getById(newsDTO.getId()).getFileEntity();
            String newFileName = new SimpleDateFormat("dd-MM-yyyy HH-mm").format(new Date());
            finalPath = fileLocation +  newFileName;
            if (newsDTO.getFile()!=null) {
                FileCopyUtils.copy(newsDTO.getFile().getBytes(), new File(finalPath));
            }
          fileEntity.setFileName(newFileName);
            return fileEntity;
        }
    }

}
