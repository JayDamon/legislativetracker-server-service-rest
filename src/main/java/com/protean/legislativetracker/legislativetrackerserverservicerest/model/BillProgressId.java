package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class BillProgressId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @Column(name = "progress_step")
    private Integer progressEventID;

    public BillProgressId() {
    }

    public BillProgressId(Bill bill, Integer progressEventID) {
        this.bill = bill;
        this.progressEventID = progressEventID;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Integer getProgressEventID() {
        return progressEventID;
    }

    public void setProgressEventID(Integer progressEventID) {
        this.progressEventID = progressEventID;
    }
}
