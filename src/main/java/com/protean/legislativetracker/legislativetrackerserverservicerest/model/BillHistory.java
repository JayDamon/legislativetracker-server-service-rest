package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "bill_history")
public class BillHistory {

    @EmbeddedId
    private BillHistoryId id;

    @ManyToOne
    @JoinColumn(name = "bill_id", insertable = false, updatable = false)
    private Bill bill;
    @Column(name = "history_major")
    private Integer historyMajor;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "history_body_id")
    private Body body;
    @Column(name = "history_date")
    private Date date;
    @Column(name = "history_action")
    private String action;

    public BillHistory() {
    }

    public BillHistory(Bill bill, Integer historyStep, Integer historyMajor, Body body, Date date, String action) {
        this.bill = bill;
        this.historyMajor = historyMajor;
        this.body = body;
        this.date = date;
        this.action = action;
        this.id = new BillHistoryId(bill, historyStep);
    }

    public BillHistoryId getId() {
        return id;
    }

    public void setId(BillHistoryId id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Integer getHistoryMajor() {
        return historyMajor;
    }

    public void setHistoryMajor(Integer historyMajor) {
        this.historyMajor = historyMajor;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillHistory that = (BillHistory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(bill, that.bill) &&
                Objects.equals(historyMajor, that.historyMajor) &&
                Objects.equals(body, that.body) &&
                Objects.equals(date, that.date) &&
                Objects.equals(action, that.action);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, bill, historyMajor, body, date, action);
    }

    @Override
    public String toString() {
        return "BillHistory{" +
                "id=" + id +
                ", bill=" + bill +
                ", historyMajor=" + historyMajor +
                ", body=" + body +
                ", date=" + date +
                ", action='" + action + '\'' +
                '}';
    }
}
