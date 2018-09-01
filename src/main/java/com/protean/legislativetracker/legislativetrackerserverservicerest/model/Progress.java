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
    @Column(name = "progress_event_id", nullable = false)
    private Integer id;
    @Column(name = "progress_desc", nullable = false)
    private String description;

    public Progress() {
    }

    public Progress(Integer id, String description) {
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
        Progress progress = (Progress) o;
        return Objects.equals(id, progress.id) &&
                Objects.equals(description, progress.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "Progress{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
