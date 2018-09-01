package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BillSponsorId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill billId;
    @Column(name = "sponsor_order")
    private Integer sponsorOrder;

    public BillSponsorId() {
    }

    public BillSponsorId(Bill billId, Integer sponsorOrder) {
        this.billId = billId;
        this.sponsorOrder = sponsorOrder;
    }

    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
    }

    public Integer getSponsorOrder() {
        return sponsorOrder;
    }

    public void setSponsorOrder(Integer sponsorOrder) {
        this.sponsorOrder = sponsorOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillSponsorId that = (BillSponsorId) o;
        return Objects.equals(billId, that.billId) &&
                Objects.equals(sponsorOrder, that.sponsorOrder);
    }

    @Override
    public int hashCode() {

        return Objects.hash(billId, sponsorOrder);
    }

    @Override
    public String toString() {
        return "BillSponsorId{" +
                "billId=" + billId +
                ", sponsorOrder=" + sponsorOrder +
                '}';
    }
}
