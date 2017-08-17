package ru.mail.mina.repository.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Администратор on 25.07.2017.
 */
@Entity
@Table(name = "t_message")
public class Message implements Serializable {
    private static final long serialVersionUID = -4622634059113485735L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;

    private Integer userReceivedId;

    private Integer fk_UserSent;

    public Message() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserReceivedId() {
        return userReceivedId;
    }

    public void setUserReceivedId(Integer userReceivedId) {
        this.userReceivedId = userReceivedId;
    }

    public Integer getFk_UserSent() {
        return fk_UserSent;
    }

    public void setFk_UserSent(Integer fk_UserSent) {
        this.fk_UserSent = fk_UserSent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
