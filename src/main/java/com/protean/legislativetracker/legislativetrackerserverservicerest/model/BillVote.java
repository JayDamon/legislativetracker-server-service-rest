package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "bill_vote")
public class BillVote {
    @Id
    @Column(name = "roll_call_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @OneToOne
    @JoinColumn(name = "roll_call_body_id")
    private Body body;
    @Column(name = "roll_call_desc")
    private Date date;
    @Column(name = "yea")
    private Integer yea;
    @Column(name = "nay")
    private Integer nay;
    @Column(name = "nv")
    private Integer nv;
    @Column(name = "abset")
    private Integer absent;
    @Column(name = "total")
    private Integer total;
    @Column(name = "passed")
    private Integer passed;
    @Column(name = "legiscan_url")
    private URL legiscanUrl;
    @Column(name = "state_url")
    private URL stateUrl;
    @Column(name = "updated")
    private Calendar updated;
    @Column(name = "created")
    private Calendar created;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rollCall")
    private Set<BillVoteDetail> details;

    public BillVote() {
    }

    public BillVote(Long id, Bill bill, Body body, Date date, Integer yea, Integer nay, Integer nv, Integer absent, Integer total, Integer passed, URL legiscanUrl, URL stateUrl, Calendar updated, Calendar created, Set<BillVoteDetail> details) {
        this.id = id;
        this.bill = bill;
        this.body = body;
        this.date = date;
        this.yea = yea;
        this.nay = nay;
        this.nv = nv;
        this.absent = absent;
        this.total = total;
        this.passed = passed;
        this.legiscanUrl = legiscanUrl;
        this.stateUrl = stateUrl;
        this.updated = updated;
        this.created = created;
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
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

    public Integer getYea() {
        return yea;
    }

    public void setYea(Integer yea) {
        this.yea = yea;
    }

    public Integer getNay() {
        return nay;
    }

    public void setNay(Integer nay) {
        this.nay = nay;
    }

    public Integer getNv() {
        return nv;
    }

    public void setNv(Integer nv) {
        this.nv = nv;
    }

    public Integer getAbsent() {
        return absent;
    }

    public void setAbsent(Integer absent) {
        this.absent = absent;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPassed() {
        return passed;
    }

    public void setPassed(Integer passed) {
        this.passed = passed;
    }

    public URL getLegiscanUrl() {
        return legiscanUrl;
    }

    public void setLegiscanUrl(URL legiscanUrl) {
        this.legiscanUrl = legiscanUrl;
    }

    public URL getStateUrl() {
        return stateUrl;
    }

    public void setStateUrl(URL stateUrl) {
        this.stateUrl = stateUrl;
    }

    public Calendar getUpdated() {
        return updated;
    }

    public void setUpdated(Calendar updated) {
        this.updated = updated;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    public Set<BillVoteDetail> getDetails() {
        return details;
    }

    public void setDetails(Set<BillVoteDetail> details) {
        this.details = details;
    }
}
