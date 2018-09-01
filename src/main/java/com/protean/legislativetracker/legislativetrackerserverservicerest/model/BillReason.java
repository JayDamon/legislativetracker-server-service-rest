package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "bill_reason")
public class BillReason {
    @Id
    @Column(name = "bill_id", nullable = false)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reason_id")
    private Reason reason;
    @Column(name = "created", insertable = false, updatable = false)
    private Calendar created;

    public BillReason() {
    }

    public BillReason(Long id, Reason reason, Calendar created) {
        this.id = id;
        this.reason = reason;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
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
        BillReason that = (BillReason) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(reason, that.reason) &&
                Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, reason, created);
    }

    @Override
    public String toString() {
        return "BillReason{" +
                "id=" + id +
                ", reason=" + reason +
                ", created=" + created +
                '}';
    }
}
