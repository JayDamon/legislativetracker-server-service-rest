package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class BillProgressId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @Column(name = "progress_step")
    private Integer progressEventId;

    public BillProgressId() {
    }

    public BillProgressId(Bill bill, Integer progressEventId) {
        this.bill = bill;
        this.progressEventId = progressEventId;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Integer getProgressEventId() {
        return progressEventId;
    }

    public void setProgressEventId(Integer progressEventId) {
        this.progressEventId = progressEventId;
    }
}
