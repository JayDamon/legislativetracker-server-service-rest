package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class BillHistoryId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill billId;
    @Column(name = "history_step")
    private Integer historyStep;

    public BillHistoryId() {
    }

    public BillHistoryId(Bill billId, Integer historyStep) {
        this.billId = billId;
        this.historyStep = historyStep;
    }

    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
    }

    public Integer getHistoryStep() {
        return historyStep;
    }

    public void setHistoryStep(Integer historyStep) {
        this.historyStep = historyStep;
    }

}
