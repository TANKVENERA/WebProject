package ru.mail.mina.service.modelDTO;

import ru.mail.mina.repository.model.FileEntity;
import ru.mail.mina.repository.model.Comment;
import ru.mail.mina.repository.model.User;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Администратор on 25.07.2017.
 */
public class AdDTO {

    private Integer id;

    private String markAuto;

    private String modelAuto;

    private Integer yearOfIssue;

    private Integer price;

    private String transmission;

    private String engine;

    private Integer mileAge;

    private String color;

    private String bodyStyle;

    private String carDescription;

    private Integer fk_Basket;

    private User user;

    private Set<Comment> comments = new HashSet<>();

    private List<FileEntity> carPhotos = new LinkedList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarkAuto() {
        return markAuto;
    }

    public void setMarkAuto(String markAuto) {
        this.markAuto = markAuto;
    }

    public String getModelAuto() {
        return modelAuto;
    }

    public void setModelAuto(String modelAuto) {
        this.modelAuto = modelAuto;
    }

    public Integer getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(Integer yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Integer getMileAge() {
        return mileAge;
    }

    public void setMileAge(Integer mileAge) {
        this.mileAge = mileAge;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public String getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }

    public Integer getFk_Basket() {
        return fk_Basket;
    }

    public void setFk_Basket(Integer fk_Basket) {
        this.fk_Basket = fk_Basket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public List<FileEntity> getCarPhotos() {
        return carPhotos;
    }

    public void setCarPhotos(List<FileEntity> carPhotos) {
        this.carPhotos = carPhotos;
    }
}
