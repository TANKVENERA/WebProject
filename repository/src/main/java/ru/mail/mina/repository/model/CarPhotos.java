package ru.mail.mina.repository.model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Администратор on 05.08.2017.
 */
@Entity
@Table(name = "t_CarPhotos")
public class CarPhotos implements Serializable {

    private static final long serialVersionUID = -5700950605416486180L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "F_FilePath")
    private String filePath;

    public CarPhotos() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPhotos carPhotos = (CarPhotos) o;
        return Objects.equals(id, carPhotos.id) &&
                Objects.equals(filePath, carPhotos.filePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filePath);
    }
}
