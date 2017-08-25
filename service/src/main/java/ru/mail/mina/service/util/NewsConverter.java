package ru.mail.mina.service.util;

import ru.mail.mina.repository.model.News;
import ru.mail.mina.service.modelDTO.NewsDTO;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Администратор on 20.08.2017.
 */
public class NewsConverter {

    private NewsConverter() {

    }

    public static NewsDTO convert(News news) { // downloading from database
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setId(news.getId());
        newsDTO.setText(news.getText());
        newsDTO.setTitle(news.getTitle());
        newsDTO.setDate(news.getDate());
        newsDTO.setFileEntity(news.getFileEntity());
        return newsDTO;
    }

    public static News convert(NewsDTO newsDTO) {
        News news = new News();
        news.setText(newsDTO.getText());
        news.setDate(newsDTO.getDate());
        news.setTitle(newsDTO.getTitle());
        news.setId(newsDTO.getId());
        return news;
    }
}
