package ru.mail.mina.repository.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.IncrementGenerator;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Администратор on 23.07.2017.
 */
@Entity
@Table(name = "t_news")
public class News implements Serializable{
    private static final long serialVersionUID = 4715224844837128271L;

    @Id
    @GenericGenerator(name="k" , strategy="increment")
    @GeneratedValue (generator="k")
//    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String date;

    private String title;

    private String text;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="FK_FileEntity")
    private FileEntity fileEntity;

    private Integer fk_User;

    public News() {

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

    public Integer getFk_User() {
        return fk_User;
    }

    public void setFk_User(Integer fk_User) {
        this.fk_User = fk_User;
    }

    public FileEntity getFileEntity() {
        return fileEntity;
    }

    public void setFileEntity(FileEntity fileEntity) {
        this.fileEntity = fileEntity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(id, news.id) &&
                Objects.equals(date, news.date) &&
                Objects.equals(text, news.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, text);
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", date=" + date +
                ", text='" + text + '\'' +
                ", fileEntity=" + fileEntity +
                ", fk_User=" + fk_User +
                '}';
    }
}