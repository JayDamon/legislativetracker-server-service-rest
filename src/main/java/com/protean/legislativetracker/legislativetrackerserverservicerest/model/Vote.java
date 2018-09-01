package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "vote")
public class Vote {
    @Id
    @Column(name = "vote_id")
    private Integer vote;
    @Column(name = "vote_desc")
    private String description;

    public Vote() {
    }

    public Vote(Integer vote, String description) {
        this.vote = vote;
        this.description = description;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
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
        Vote vote1 = (Vote) o;
        return Objects.equals(vote, vote1.vote) &&
                Objects.equals(description, vote1.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(vote, description);
    }

    @Override
    public String toString() {
        return "Vote{" +
                "vote=" + vote +
                ", description='" + description + '\'' +
                '}';
    }
}
