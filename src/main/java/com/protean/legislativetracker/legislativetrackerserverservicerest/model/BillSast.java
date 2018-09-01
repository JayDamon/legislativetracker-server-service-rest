package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bill_sast")
public class BillSast {

    @EmbeddedId
    private BillSastId id;

    @ManyToOne
    @JoinColumn(name = "bill_id", insertable = false, updatable = false)
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "sast_bill_id", insertable = false, updatable = false)
    private Bill sastBill;

    @OneToOne
    @JoinColumn(name = "sast_type_id")
    private SastType sastType;

    public BillSast() {
    }

    public BillSast(Bill bill, Bill sastBill, SastType sastType) {
        this.bill = bill;
        this.sastBill = sastBill;
        this.sastType = sastType;
        this.id = new BillSastId(bill, sastBill);

    }

    public BillSastId getId() {
        return id;
    }

    public void setId(BillSastId id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Bill getSastBill() {
        return sastBill;
    }

    public void setSastBill(Bill sastBill) {
        this.sastBill = sastBill;
    }

    public SastType getSastType() {
        return sastType;
    }

    public void setSastType(SastType sastType) {
        this.sastType = sastType;
    }

}
