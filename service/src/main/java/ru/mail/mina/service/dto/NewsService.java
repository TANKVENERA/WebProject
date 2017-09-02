package ru.mail.mina.service.dto;

import ru.mail.mina.service.model.NewsDTO;
import java.io.IOException;
import java.util.List;

/**
 * Created by Администратор on 20.08.2017.
 */
public interface NewsService {

    List<NewsDTO> findAll();

    void saveNews(NewsDTO newsDTO ) throws IOException;

    void saveOrUpdate (NewsDTO newsDTO) throws IOException;

    void update (NewsDTO newsDTO) throws IOException;

    void delete( Integer id);

    NewsDTO getById (Integer id);
}


