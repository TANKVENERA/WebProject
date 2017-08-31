package ru.mail.mina.service.model;

import ru.mail.mina.repository.model.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Администратор on 25.07.2017.
 */
public class UserDTO {

    private Integer id;

    private String username;

    private String email;

    private String password;

    private Role role;

    private Set<AdDTO> ads = new HashSet<>();

    private Set<NewsDTO> news = new HashSet<>();

    private Basket basket;

    private Set<Comment> comments = new HashSet<>();

    private Set<Message> messages = new HashSet<>();

    private Set<ServerMessage> serverMessages = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Set<AdDTO> getAds() {
        return ads;
    }

    public void setAds(Set<AdDTO> ads) {
        this.ads = ads;
    }

    public Set<NewsDTO> getNews() {
        return news;
    }

    public void setNews(Set<NewsDTO> news) {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
