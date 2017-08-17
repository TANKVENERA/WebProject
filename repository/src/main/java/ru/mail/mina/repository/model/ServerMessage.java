package ru.mail.mina.repository.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Администратор on 25.07.2017.
 */

@Entity
@Table(name = "t_servermessage")
public class ServerMessage implements Serializable {

    private static final long serialVersionUID = -1822629561275995399L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "serverMessages", cascade ={  CascadeType.REMOVE})
    private Set<User> users = new HashSet<>();

    public ServerMessage() {

    }

    @PreRemove
    private void removeGroupsFromUsers() {
        for (User u : users) {
            u.getServerMessages().remove(this);
        }
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
