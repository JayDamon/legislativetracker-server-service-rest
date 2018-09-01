package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class BillSastId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill billId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sast_bill_id")
    private Bill sastBillId;

    public BillSastId() {
    }

    public BillSastId(Bill billId, Bill sastBillId) {
        this.billId = billId;
        this.sastBillId = sastBillId;
    }

    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
    }

    public Bill getSastBillId() {
        return sastBillId;
    }

    public void setSastBillId(Bill sastBillId) {
        this.sastBillId = sastBillId;
    }
}
