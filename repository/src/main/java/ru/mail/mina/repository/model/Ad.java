package ru.mail.mina.repository.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Администратор on 15.07.2017.
 */
@Entity
@Table(name="t_ad")
public class Ad implements Serializable {

    private static final long serialVersionUID = 8348179393581584247L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
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



    @Column(name = "F_CARDESCRIPTION", length = 2000)
    private String carDescription;

    private Integer fk_Basket;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_User", nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_Ad")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_CarPhotos")
    private List<CarPhotos> carPhotos = new LinkedList<>();

    public Ad() {

    }

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

    public String getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(String carState) {
        this.carDescription = carState;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getFk_Basket() {
        return fk_Basket;
    }

    public void setFk_Basket(Integer fk_Basket) {
        this.fk_Basket = fk_Basket;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public List<CarPhotos> getCarPhotos() {
        return carPhotos;
    }

    public void setCarPhotos(List<CarPhotos> carPhotos) {
        this.carPhotos = carPhotos;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return Objects.equals(id, ad.id) &&
                Objects.equals(markAuto, ad.markAuto) &&
                Objects.equals(modelAuto, ad.modelAuto) &&
                Objects.equals(yearOfIssue, ad.yearOfIssue) &&
                Objects.equals(price, ad.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, markAuto, modelAuto, yearOfIssue, price);
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", markAuto='" + markAuto + '\'' +
                ", modelAuto='" + modelAuto + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                ", price=" + price +
                ", transmission='" + transmission + '\'' +
                ", engine='" + engine + '\'' +
                ", mileAge=" + mileAge +
                ", color='" + color + '\'' +
                ", bodyStyle='" + bodyStyle + '\'' +
                ", carDescription='" + carDescription + '\'' +
                ", fk_Basket=" + fk_Basket +
                ", carPhotos=" + carPhotos +
                '}';
    }
}

