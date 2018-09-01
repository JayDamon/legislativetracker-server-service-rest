package com.protean.legislativetracker.legislativetrackerserverservicerest.model;


import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class BillCalendarId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @Column(name = "event_hash")
    private String eventHash;

    public BillCalendarId() {
    }

    public BillCalendarId(Bill bill, String eventHash) {
        this.bill = bill;
        this.eventHash = eventHash;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public String getEventHash() {
        return eventHash;
    }

    public void setEventHash(String eventHash) {
        this.eventHash = eventHash;
    }
}
