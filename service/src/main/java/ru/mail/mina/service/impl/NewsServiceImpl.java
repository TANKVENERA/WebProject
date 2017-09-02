package ru.mail.mina.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.mail.mina.repository.dao.NewsGenericHibernateDao;
import ru.mail.mina.repository.dao.UserGenericHibernateDao;
import ru.mail.mina.repository.model.NewsEntity;
import ru.mail.mina.repository.model.News;
import ru.mail.mina.repository.model.User;
import ru.mail.mina.service.dto.NewsService;
import ru.mail.mina.service.model.AppUserPrincipal;
import ru.mail.mina.service.model.NewsDTO;
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


    private final NewsGenericHibernateDao newsGenericHibernateDao;

    @Autowired
    private Environment environment;


    private final UserGenericHibernateDao userGenericHibernateDao;

    @Autowired
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
            NewsEntity newsEntity = getNewsEntity(newsDTO);
            news.setNewsEntity(newsEntity); // внесение файла в news
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
            NewsEntity newsEntity = getNewsEntity(newsDTO);
            news.setNewsEntity(newsEntity); // внесение файла в news
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
            NewsEntity newsEntity = getNewsEntity(newsDTO);
            news.setNewsEntity(newsEntity); // внесение файла в news
            newsGenericHibernateDao.saveOrUpdate(news); // updating user and saving all extended entities by cascade
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public NewsDTO getById(Integer id) {
        News news = newsGenericHibernateDao.findById(id);
        NewsDTO newsDTO = NewsConverter.convert(news);
        return newsDTO;
    }

    private NewsEntity getNewsEntity(NewsDTO newsDTO) throws IOException {
        Integer id = newsDTO.getId();
        String date = newsDTO.getDate();
        MultipartFile multipartFile = newsDTO.getFile();
        String finalPath;
        String fileName = date == null ? getById(id).getDate() : date;
        String fileLocation = environment.getProperty("upload.newsLocation") + fileName + "\\";
        File file = new File(fileLocation);
        if (!file.exists()) {
            NewsEntity newsEntity = new NewsEntity();
            file.mkdirs();
            finalPath = fileLocation + fileName;
            FileCopyUtils.copy(multipartFile.getBytes(), new File(finalPath)); // из переменной MultiPartFile file извлекается картинка
            newsEntity.setFilePath(fileLocation);
            newsEntity.setFileName(fileName);
            return newsEntity;
        } else {
            NewsEntity newsEntity = getById(id).getNewsEntity();
            if (!multipartFile.isEmpty()) {
                String newFileName = new SimpleDateFormat("dd-MM-yyyy HH-mm").format(new Date());
                finalPath = fileLocation + newFileName;
                FileCopyUtils.copy(multipartFile.getBytes(), new File(finalPath));
                newsEntity.setFileName(newFileName);
            }
            return newsEntity;
        }
    }
}
