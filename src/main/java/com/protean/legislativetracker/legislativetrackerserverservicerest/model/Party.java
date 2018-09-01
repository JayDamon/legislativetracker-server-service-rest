package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "party")
public class Party {
    @Id
    @Column(name = "party_id")
    private Integer id;
    @Column(name = "party_abbr")
    private Character abbreviation;
    @Column(name = "party_short")
    private String partyShort;
    @Column(name = "party_name")
    private String name;

    public Party() {
    }

    public Party(Integer id, Character abbreviation, String partyShort, String name) {
        this.id = id;
        this.abbreviation = abbreviation;
        this.partyShort = partyShort;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(Character abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getPartyShort() {
        return partyShort;
    }

    public void setPartyShort(String partyShort) {
        this.partyShort = partyShort;
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
        Party party = (Party) o;
        return Objects.equals(id, party.id) &&
                Objects.equals(abbreviation, party.abbreviation) &&
                Objects.equals(partyShort, party.partyShort) &&
                Objects.equals(name, party.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, abbreviation, partyShort, name);
    }

    @Override
    public String toString() {
        return "Party{" +
                "id=" + id +
                ", abbreviation=" + abbreviation +
                ", partyShort='" + partyShort + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
