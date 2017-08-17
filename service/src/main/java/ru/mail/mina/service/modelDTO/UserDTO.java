package ru.mail.mina.service.modelDTO;

import ru.mail.mina.repository.model.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Администратор on 25.07.2017.
 */
public class UserDTO {

    private Integer id;

    private String login;

    private String email;

    private String password;

    private Set<Ad> ads = new HashSet<>();

    private Set<News> news = new HashSet<>();

    private Basket basket;

    private Set<Comment> comments = new HashSet<>();

    private Set<Message> messages = new HashSet<>();

    private Set<ServerMessage> serverMessages = new HashSet<>();

    public UserDTO() {
    }

    public UserDTO (User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.ads = user.getAds();
        this.news = user.getNews();
        this.basket = user.getBasket();
        this.comments = user.getComments();
        this.messages = user.getMessages();
        this.serverMessages = user.getServerMessages();

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

    public Set<News> getNews() {
        return news;
    }

    public void setNews(Set<News> news) {
        this.news = news;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
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
}
