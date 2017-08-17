package ru.mail.mina.repository.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Администратор on 23.07.2017.
 */
@Entity
@Table(name = "t_news")
public class News implements Serializable{
    private static final long serialVersionUID = 4715224844837128271L;

    @Id
    @GeneratedValue (strategy = IDENTITY)
    private Integer id;

    private Date date;

    private String text;

    //foto

    private Integer fk_User;

    public News() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
