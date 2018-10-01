package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "committee")
public class Committee {
    @Id
    @Column(name = "committee_id", nullable = false)
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "committee_body_id", nullable = false)
    private Body body;
    @Column(name = "committee_name", nullable = false)
    private String name;

    public Committee() {
    }

    public Committee(Integer id, Body body, String name) {
        this.id = id;
        this.body = body;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Committee committee = (Committee) o;
        return Objects.equals(id, committee.id) &&
                Objects.equals(body, committee.body) &&
                Objects.equals(name, committee.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, body, name);
    }

    @Override
    public String toString() {
        return "Committee{" +
                "id=" + id +
                ", body=" + body +
                ", name='" + name + '\'' +
                '}';
    }
}
