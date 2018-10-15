package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "bill_supplement")
public class BillSupplement {

    @Id
    @Column(name = "supplement_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @Column(name = "local_copy")
    private Integer localCopy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplement_type_id")
    private SupplementType supplementType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplement_mime_id")
    private MimeType mimeType;

    @Column(name = "supplement_date")
    private Date date;
    @Column(name = "supplement_title")
    private String title;
    @Column(name = "supplement_desc")
    private String description;
    @Column(name = "legiscan_url")
    private URL legiscanUrl;
    @Column(name = "state_url")
    private URL stateUrl;
    @Column(name = "updated")
    private Calendar updated;
    @Column(name = "created")
    private Calendar created;

    public BillSupplement() {
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

    public Integer getLocalCopy() {
        return localCopy;
    }

    public void setLocalCopy(Integer localCopy) {
        this.localCopy = localCopy;
    }

    public SupplementType getSupplementType() {
        return supplementType;
    }

    public void setSupplementType(SupplementType supplementType) {
        this.supplementType = supplementType;
    }

    public MimeType getMimeType() {
        return mimeType;
    }

    public void setMimeType(MimeType mimeType) {
        this.mimeType = mimeType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillSupplement that = (BillSupplement) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(bill, that.bill) &&
                Objects.equals(localCopy, that.localCopy) &&
                Objects.equals(supplementType, that.supplementType) &&
                Objects.equals(mimeType, that.mimeType) &&
                Objects.equals(date, that.date) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(legiscanUrl, that.legiscanUrl) &&
                Objects.equals(stateUrl, that.stateUrl) &&
                Objects.equals(updated, that.updated) &&
                Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, bill, localCopy, supplementType, mimeType, date, title, description, legiscanUrl, stateUrl, updated, created);
    }

    @Override
    public String toString() {
        return "BillSupplement{" +
                "id=" + id +
                ", bill=" + bill +
                ", localCopy=" + localCopy +
                ", supplementType=" + supplementType +
                ", mimeType=" + mimeType +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", legiscanUrl=" + legiscanUrl +
                ", stateUrl=" + stateUrl +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }
}
