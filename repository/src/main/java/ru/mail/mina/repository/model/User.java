package ru.mail.mina.repository.model;




import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Администратор on 12.07.2017.
 */

@Entity
@Table(name = "t_user")
public class User implements Serializable {
    private static final long serialVersionUID = 3416502531954489914L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String login;

    private String email;

    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Ad> ads = new HashSet<>();

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_User")
    private Set<News> news = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Basket basket;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_UserSent")
    private Set<Message> messages = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade ={CascadeType.ALL, CascadeType.REMOVE})
    @JoinTable (name = "t_user_serverMessage", joinColumns = {@JoinColumn(name = "fk_User", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "fk_ServerMessage", referencedColumnName = "id")})
    private Set<ServerMessage> serverMessages = new HashSet<>();

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Ad> getAds() {
        return ads;
    }

    public void setAds(Set<Ad> ads) {
        this.ads = ads;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Set<News> getNews() {
        return news;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void setNews(Set<News> news) {
        this.news = news;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public Set<ServerMessage> getServerMessages() {
        return serverMessages;
    }

    public void setServerMessages(Set<ServerMessage> serverMessages) {
        this.serverMessages = serverMessages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, email, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ads=" + ads +
                '}';
    }
}
