package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bill_sponsor")
public class BillSponsor {

    @EmbeddedId
    private BillSponsorId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id", insertable = false, updatable = false)
    private Bill bill;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sponsort_type_id")
    private SponsorType sponsorType;

    public BillSponsor() {
    }

    public BillSponsor(Bill bill, Integer sponsorOrder, Person person, SponsorType sponsorType) {
        this.bill = bill;
        this.person = person;
        this.sponsorType = sponsorType;
        this.id = new BillSponsorId(bill, sponsorOrder);
    }

    public BillSponsorId getId() {
        return id;
    }

    public void setId(BillSponsorId id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public SponsorType getSponsorType() {
        return sponsorType;
    }

    public void setSponsorType(SponsorType sponsorType) {
        this.sponsorType = sponsorType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillSponsor that = (BillSponsor) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(bill, that.bill) &&
                Objects.equals(person, that.person) &&
                Objects.equals(sponsorType, that.sponsorType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, bill, person, sponsorType);
    }

    @Override
    public String toString() {
        return "BillSponsor{" +
                "id=" + id +
                ", bill=" + bill +
                ", person=" + person +
                ", sponsorType=" + sponsorType +
                '}';
    }
}
