package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "bill_progress")
public class BillProgress {

    @EmbeddedId
    private BillProgressId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id", insertable = false, updatable = false)
    private Bill bill;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "progress_event_id")
    private Progress progress;

    @Column(name = "progress_date")
    private Date progressDate;

    public BillProgress() {
    }

    public BillProgress(Bill bill, Progress progress, Integer progressStep, Date progressDate) {
        this.bill = bill;
        this.progress = progress;
        this.progressDate = progressDate;
        this.id = new BillProgressId(bill, progressStep);
    }

    public BillProgressId getId() {
        return id;
    }

    public void setId(BillProgressId id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public Date getProgressDate() {
        return progressDate;
    }

    public void setProgressDate(Date progressDate) {
        this.progressDate = progressDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillProgress that = (BillProgress) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(bill, that.bill) &&
                Objects.equals(progress, that.progress) &&
                Objects.equals(progressDate, that.progressDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, bill, progress, progressDate);
    }

    @Override
    public String toString() {
        return "BillProgress{" +
                "id=" + id +
                ", bill=" + bill +
                ", progress=" + progress +
                ", progressDate=" + progressDate +
                '}';
    }
}
