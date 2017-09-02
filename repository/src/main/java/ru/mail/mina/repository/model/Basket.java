package ru.mail.mina.repository.model;

import javax.persistence.*;
import java.io.Serializable;



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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_Ad")
    private Ad ad ;



    private Integer loggedUserId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public Integer getLoggedUserId() {
        return loggedUserId;
    }

    public void setLoggedUserId(Integer loggedUserId) {
        this.loggedUserId = loggedUserId;
    }
}
