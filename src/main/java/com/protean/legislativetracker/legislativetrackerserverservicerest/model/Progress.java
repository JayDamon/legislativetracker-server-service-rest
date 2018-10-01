package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "progress")
public class Progress {
    @Id
    @Column(name = "progress_step_id", nullable = false)
    private Integer Id;
    @Column(name = "progress_desc", nullable = false)
    private String description;

    public Progress() {
    }

    public Progress(Integer Id, String description) {
        this.Id = Id;
        this.description = description;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
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
        Progress progress = (Progress) o;
        return Objects.equals(Id, progress.Id) &&
                Objects.equals(description, progress.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Id, description);
    }

    @Override
    public String toString() {
        return "Progress{" +
                "Id=" + Id +
                ", description='" + description + '\'' +
                '}';
    }
}
