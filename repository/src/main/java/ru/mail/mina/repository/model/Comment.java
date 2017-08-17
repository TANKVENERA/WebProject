package ru.mail.mina.repository.model;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Администратор on 24.07.2017.
 */
@Entity
@Table(name = "t_comments")
public class Comment implements Serializable{
    private static final long serialVersionUID = 6889505835500076829L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String text;

 //   private Integer fk_User;

    private Integer fk_Ad;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_User")
    private User user;

    public Comment() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    public Integer getFk_User() {
//        return fk_User;
//    }
//
//    public void setFk_User(Integer fk_User) {
//        this.fk_User = fk_User;
//    }

    public Integer getFk_Ad() {
        return fk_Ad;
    }

    public void setFk_Ad(Integer fk_Ad) {
        this.fk_Ad = fk_Ad;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
