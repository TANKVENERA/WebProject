package ru.mail.mina.service.model;

import org.springframework.web.multipart.MultipartFile;
import ru.mail.mina.repository.model.NewsEntity;

import java.util.Objects;

/**
 * Created by Администратор on 25.07.2017.
 */
public class NewsDTO {

    private Integer id;

    private String date;

    private String title;

    private String text;

    private MultipartFile file; // for uploading file in filesystem

    private Integer fk_User;

    private NewsEntity newsEntity;

    public NewsDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Integer getFk_User() {
        return fk_User;
    }

    public void setFk_User(Integer fk_User) {
        this.fk_User = fk_User;
    }

    public String getTitle() {
        return title;
    }

    public NewsEntity getNewsEntity() {
        return newsEntity;
    }

    public void setNewsEntity(NewsEntity newsEntity) {
        this.newsEntity = newsEntity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsDTO newsDTO = (NewsDTO) o;
        return Objects.equals(id, newsDTO.id) &&
                Objects.equals(date, newsDTO.date) &&
                Objects.equals(title, newsDTO.title) &&
                Objects.equals(text, newsDTO.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, title, text);
    }

    @Override
    public String toString() {
        return "NewsDTO{" +
                "id=" + id +
                ", date=" + date +
                ", text='" + text + '\'' +
                ", file=" + file +
                ", fk_User=" + fk_User +
                '}';
    }
}
