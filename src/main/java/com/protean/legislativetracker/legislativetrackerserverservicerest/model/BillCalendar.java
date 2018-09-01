package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "bill_calendar")
public class BillCalendar {

    @EmbeddedId
    private BillCalendarId id;

    @ManyToOne
    @JoinColumn(name = "bill_id", insertable = false, updatable = false)
    private Bill bill;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_type_id")
    private EventType eventType;

    @Column(name = "event_date")
    private Date date;
    @Column(name = "event_time")
    private Time time;
    @Column(name = "event_location")
    private String location;
    @Column(name = "event_desc")
    private String description;
    @Column(name = "udpated")
    private Calendar updated;
    @Column(name = "created")
    private Calendar created;

    public BillCalendar() {
    }

    public BillCalendar(Bill bill, String eventHash, EventType eventType, Date date, Time time, String location, String description, Calendar updated, Calendar created) {
        this.bill = bill;
        this.eventType = eventType;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.updated = updated;
        this.created = created;
        this.id = new BillCalendarId(bill, eventHash);
    }

    public BillCalendarId getId() {
        return id;
    }

    public void setId(BillCalendarId id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        BillCalendar that = (BillCalendar) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(bill, that.bill) &&
                Objects.equals(eventType, that.eventType) &&
                Objects.equals(date, that.date) &&
                Objects.equals(time, that.time) &&
                Objects.equals(location, that.location) &&
                Objects.equals(description, that.description) &&
                Objects.equals(updated, that.updated) &&
                Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, bill, eventType, date, time, location, description, updated, created);
    }

    @Override
    public String toString() {
        return "BillCalendar{" +
                "id=" + id +
                ", bill=" + bill +
                ", eventType=" + eventType +
                ", date=" + date +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }
}
