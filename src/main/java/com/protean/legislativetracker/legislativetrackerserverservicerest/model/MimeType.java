package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "mime_type")
public class MimeType {
    @Id
    @Column(name = "mime_id")
    private Integer id;
    @Column(name = "mime_type")
    private String type;
    @Column(name = "is_binary")
    private Boolean isBinary;

    public MimeType() {
    }

    public MimeType(Integer id, String type, Boolean isBinary) {
        this.id = id;
        this.type = type;
        this.isBinary = isBinary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getBinary() {
        return isBinary;
    }

    public void setBinary(Boolean binary) {
        isBinary = binary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MimeType mimeType = (MimeType) o;
        return Objects.equals(id, mimeType.id) &&
                Objects.equals(type, mimeType.type) &&
                Objects.equals(isBinary, mimeType.isBinary);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, type, isBinary);
    }

    @Override
    public String toString() {
        return "MimeType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", isBinary=" + isBinary +
                '}';
    }
}
