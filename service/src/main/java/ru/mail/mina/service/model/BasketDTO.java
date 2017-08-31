package ru.mail.mina.service.model;

import ru.mail.mina.repository.model.Ad;
import ru.mail.mina.repository.model.User;
import java.util.List;



/**
 * Created by Администратор on 25.07.2017.
 */
public class BasketDTO {

    private Integer id;

    private Ad ad;


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
