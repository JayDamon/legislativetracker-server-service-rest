package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "body")
public class Body { //Legislative body, i.e. House, Senate etc
    @Id
    @Column(name = "body_id", nullable = false)
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id", nullable = false)
    private State state;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
    @Column(name = "body_abbr", nullable = false)
    private Character abbreviation;
    @Column(name = "body_short")
    private String bodyShort;
    @Column(name = "body_name", nullable = false)
    private String bodyName;
    @Column(name = "body_role_abbr")
    private String bodyRoleAbbreviation;
    @Column(name = "body_role_name")
    private String bodyRoleName;

    public Body() {
    }

    public Body(Integer id, State state, Role role, Character abbreviation, String bodyShort, String bodyName, String bodyRoleAbbreviation, String bodyRoleName) {
        this.id = id;
        this.state = state;
        this.role = role;
        this.abbreviation = abbreviation;
        this.bodyShort = bodyShort;
        this.bodyName = bodyName;
        this.bodyRoleAbbreviation = bodyRoleAbbreviation;
        this.bodyRoleName = bodyRoleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Character getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(Character abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getBodyShort() {
        return bodyShort;
    }

    public void setBodyShort(String bodyShort) {
        this.bodyShort = bodyShort;
    }

    public String getBodyName() {
        return bodyName;
    }

    public void setBodyName(String bodyName) {
        this.bodyName = bodyName;
    }

    public String getBodyRoleAbbreviation() {
        return bodyRoleAbbreviation;
    }

    public void setBodyRoleAbbreviation(String bodyRoleAbbreviation) {
        this.bodyRoleAbbreviation = bodyRoleAbbreviation;
    }

    public String getBodyRoleName() {
        return bodyRoleName;
    }

    public void setBodyRoleName(String bodyRoleName) {
        this.bodyRoleName = bodyRoleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Body body = (Body) o;
        return Objects.equals(id, body.id) &&
                Objects.equals(state, body.state) &&
                Objects.equals(role, body.role) &&
                Objects.equals(abbreviation, body.abbreviation) &&
                Objects.equals(bodyShort, body.bodyShort) &&
                Objects.equals(bodyName, body.bodyName) &&
                Objects.equals(bodyRoleAbbreviation, body.bodyRoleAbbreviation) &&
                Objects.equals(bodyRoleName, body.bodyRoleName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, state, role, abbreviation, bodyShort, bodyName, bodyRoleAbbreviation, bodyRoleName);
    }

    @Override
    public String toString() {
        return "Body{" +
                "id=" + id +
                ", state=" + state +
                ", role=" + role +
                ", abbreviation=" + abbreviation +
                ", bodyShort='" + bodyShort + '\'' +
                ", bodyName='" + bodyName + '\'' +
                ", bodyRoleAbbreviation='" + bodyRoleAbbreviation + '\'' +
                ", bodyRoleName='" + bodyRoleName + '\'' +
                '}';
    }
}
