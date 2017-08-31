package ru.mail.mina.repository.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Администратор on 27.08.2017.
 */

@Entity
@Table(name = "t_adEntity")
public class AdEntity implements Serializable {

    private static final long serialVersionUID = 5667640729308238967L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "F_FilePath")
    private String filePath;

    @Column(name = "F_FileName")
    private String fileName;



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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdEntity adEntity = (AdEntity) o;
        return Objects.equals(id, adEntity.id) &&
                Objects.equals(filePath, adEntity.filePath) &&
                Objects.equals(fileName, adEntity.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filePath, fileName);
    }

    @Override
    public String toString() {
        return "AdEntity{" +
                "id=" + id +
                ", filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
