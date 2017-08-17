package ru.mail.mina.repository.model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Администратор on 21.07.2017.
 */
@Entity
@Table(name = "t_basket")
public class Basket implements Serializable {

    private static final long serialVersionUID = -2144116603434625701L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "fk_Basket")
    private List<Ad> ads;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_User")
    private User user;

    public Basket() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
