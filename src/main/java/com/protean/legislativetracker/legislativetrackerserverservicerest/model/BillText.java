package com.protean.legislativetracker.legislativetrackerserverservicerest.model;


import javax.persistence.*;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "bill_text")
public class BillText {
    @Id
    @Column(name = "text_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @Column(name = "local_copy")
    private Integer localCopy;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_text_type_id")
    private TextType textType;
    @OneToOne
    @JoinColumn(name = "mime_id")
    private MimeType mimeType;
    @Column(name = "bill_text_date")
    private Date date;
    @Column(name = "legiscan_url")
    private URL legiscanUrl;
    @Column(name = "state_url")
    private URL stateUrl;
    @Column(name = "updated")
    private Calendar updated;
    @Column(name = "created")
    private Calendar created;

    public BillText() {
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

    public TextType getTextType() {
        return textType;
    }

    public void setTextType(TextType textType) {
        this.textType = textType;
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
        BillText billText = (BillText) o;
        return Objects.equals(id, billText.id) &&
                Objects.equals(bill, billText.bill) &&
                Objects.equals(localCopy, billText.localCopy) &&
                Objects.equals(textType, billText.textType) &&
                Objects.equals(mimeType, billText.mimeType) &&
                Objects.equals(date, billText.date) &&
                Objects.equals(legiscanUrl, billText.legiscanUrl) &&
                Objects.equals(stateUrl, billText.stateUrl) &&
                Objects.equals(updated, billText.updated) &&
                Objects.equals(created, billText.created);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, bill, localCopy, textType, mimeType, date, legiscanUrl, stateUrl, updated, created);
    }

    @Override
    public String toString() {
        return "BillText{" +
                "id=" + id +
                ", bill=" + bill +
                ", localCopy=" + localCopy +
                ", textType=" + textType +
                ", mimeType=" + mimeType +
                ", date=" + date +
                ", legiscanUrl=" + legiscanUrl +
                ", stateUrl=" + stateUrl +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }
}
