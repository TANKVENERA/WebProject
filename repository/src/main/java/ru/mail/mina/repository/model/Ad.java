package ru.mail.mina.repository.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Администратор on 15.07.2017.
 */
@Entity
@Table(name="t_ad")
public class Ad implements Serializable {

    private static final long serialVersionUID = 8348179393581584247L;

    @Id
//    @GeneratedValue(strategy = IDENTITY)
    @GenericGenerator(name="k" , strategy="increment")
    @GeneratedValue (generator="k")
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

    private String date;


    @Column(name = "F_CARDESCRIPTION", length = 2000)
    private String carDescription;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_User", nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_Ad")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_Ad")
    private List<AdEntity> adEntities = new LinkedList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ad", cascade = CascadeType.ALL)
    private List<Basket> baskets = new LinkedList<>();


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


    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<AdEntity> getAdEntities() {
        return adEntities;
    }

    public void setAdEntities(List<AdEntity> adEntities) {
        this.adEntities = adEntities;
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

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
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
                '}';
    }
}

