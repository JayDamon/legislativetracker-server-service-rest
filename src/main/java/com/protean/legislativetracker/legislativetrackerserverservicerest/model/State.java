package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "state")
public class State {
    @Id
    @Column(name = "state_id", nullable = false)
    private String id;
    @Column(name = "state_abbr", nullable = false)
    private String abbreviation;
    @Column(name = "state_name", nullable = false)
    private String stateName;
    @Column(name = "biennium", nullable = false)
    private boolean biennium;
    @Column(name = "carry_over")
    private String carryOver;
    @Column(name = "capitol", nullable = false)
    private String capitol;
    @Column(name = "latitude")
    private BigDecimal latitude;
    @Column(name = "longitude")
    private BigDecimal longitude;

    public State() {
    }

    public State(String id, String abbreviation, String stateName, boolean biennium, String carryOver, String capitol, BigDecimal latitude, BigDecimal longitude) {
        this.id = id;
        this.abbreviation = abbreviation;
        this.stateName = stateName;
        this.biennium = biennium;
        this.carryOver = carryOver;
        this.capitol = capitol;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public boolean isBiennium() {
        return biennium;
    }

    public void setBiennium(boolean biennium) {
        this.biennium = biennium;
    }

    public String getCarryOver() {
        return carryOver;
    }

    public void setCarryOver(String carryOver) {
        this.carryOver = carryOver;
    }

    public String getCapitol() {
        return capitol;
    }

    public void setCapitol(String capitol) {
        this.capitol = capitol;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return biennium == state.biennium &&
                Objects.equals(id, state.id) &&
                Objects.equals(abbreviation, state.abbreviation) &&
                Objects.equals(stateName, state.stateName) &&
                Objects.equals(carryOver, state.carryOver) &&
                Objects.equals(capitol, state.capitol) &&
                Objects.equals(latitude, state.latitude) &&
                Objects.equals(longitude, state.longitude);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, abbreviation, stateName, biennium, carryOver, capitol, latitude, longitude);
    }

    @Override
    public String toString() {
        return "State{" +
                "id='" + id + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", stateName='" + stateName + '\'' +
                ", biennium=" + biennium +
                ", carryOver='" + carryOver + '\'' +
                ", capitol='" + capitol + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
