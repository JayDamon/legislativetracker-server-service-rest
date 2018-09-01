package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "sast_type")
public class SastType {
    @Id
    @Column(name = "sast_id")
    private Integer id;
    @Column(name = "sast_description")
    private String description;

    public SastType() {
    }

    public SastType(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SastType sastType = (SastType) o;
        return Objects.equals(id, sastType.id) &&
                Objects.equals(description, sastType.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "SastType{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
