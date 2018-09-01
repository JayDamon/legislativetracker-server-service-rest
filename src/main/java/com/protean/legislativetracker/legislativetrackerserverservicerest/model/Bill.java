package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @Column(name = "bill_id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "state_id", nullable = false)
    private State state;

    @OneToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @OneToOne
    @JoinColumn(name = "body_id", nullable = false)
    private Body body;

    @OneToOne
    @JoinColumn(name = "current_body_id", nullable = false)
    private Body currentBody;

    @OneToOne
    @JoinColumn(name = "bill_type_id", nullable = false)
    private Type type;

    @Column(name = "bill_number", nullable = false)
    private String bill_number;

    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.ORDINAL)
    private Status status;

    @Column(name = "status_date", nullable = false)
    private Date statusDate;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToOne
    @JoinColumn(name = "pending_committee_id", nullable = false)
    private Committee pendingCommittee;

    @Column(name = "url", nullable = false)
    private URL legiscanURL;

    @Column(name="state_link", nullable = false)
    private URL stateURL;

    @Column(name = "change_hash", nullable = false)
    private String changeHash;

    @Column(name = "updated", nullable = false)
    private Calendar updated;

    @Column(name = "created", nullable = false)
    private Calendar created;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private Set<BillProgress> progress;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private Set<BillHistory> histories;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private Set<BillSponsor> sponsors;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill", orphanRemoval = true)
    private Set<BillSast> sasts;

    @ManyToMany
    @JoinTable(name = "bill_subject",
        joinColumns = @JoinColumn(name = "bill_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjects;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private Set<BillText> texts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private Set<BillVote> votes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private Set<BillAmendment> amendments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private Set<BillSupplement> supplements;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bill")
    private Set<BillCalendar> calendars;

    public Bill() {
    }

    public Bill(Long id, State state, Session session, Body body, Body currentBody, Type type, String bill_number, Status status, Date statusDate, String title, String description, Committee pendingCommittee, URL legiscanURL, URL stateURL, String changeHash, Calendar updated, Calendar created) {
        this.id = id;
        this.state = state;
        this.session = session;
        this.body = body;
        this.currentBody = currentBody;
        this.type = type;
        this.bill_number = bill_number;
        this.status = status;
        this.statusDate = statusDate;
        this.title = title;
        this.description = description;
        this.pendingCommittee = pendingCommittee;
        this.legiscanURL = legiscanURL;
        this.stateURL = stateURL;
        this.changeHash = changeHash;
        this.updated = updated;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Body getCurrentBody() {
        return currentBody;
    }

    public void setCurrentBody(Body currentBody) {
        this.currentBody = currentBody;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getBill_number() {
        return bill_number;
    }

    public void setBill_number(String bill_number) {
        this.bill_number = bill_number;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
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

    public Committee getPendingCommittee() {
        return pendingCommittee;
    }

    public void setPendingCommittee(Committee pendingCommittee) {
        this.pendingCommittee = pendingCommittee;
    }

    public URL getLegiscanURL() {
        return legiscanURL;
    }

    public void setLegiscanURL(URL legiscanURL) {
        this.legiscanURL = legiscanURL;
    }

    public URL getStateURL() {
        return stateURL;
    }

    public void setStateURL(URL stateURL) {
        this.stateURL = stateURL;
    }

    public String getChangeHash() {
        return changeHash;
    }

    public void setChangeHash(String changeHash) {
        this.changeHash = changeHash;
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

    public Set<BillProgress> getProgress() {
        return progress;
    }

    public void setProgress(Set<BillProgress> progress) {
        this.progress = progress;
    }

    public Set<BillHistory> getHistories() {
        return histories;
    }

    public void setHistories(Set<BillHistory> histories) {
        this.histories = histories;
    }

    public Set<BillSponsor> getSponsors() {
        return sponsors;
    }

    public void setSponsors(Set<BillSponsor> sponsors) {
        this.sponsors = sponsors;
    }

    public Set<BillSast> getSasts() {
        return sasts;
    }

    public void setSasts(Set<BillSast> sasts) {
        this.sasts = sasts;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Set<BillText> getTexts() {
        return texts;
    }

    public void setTexts(Set<BillText> texts) {
        this.texts = texts;
    }

    public Set<BillVote> getVotes() {
        return votes;
    }

    public void setVotes(Set<BillVote> votes) {
        this.votes = votes;
    }

    public Set<BillAmendment> getAmendments() {
        return amendments;
    }

    public void setAmendments(Set<BillAmendment> amendments) {
        this.amendments = amendments;
    }

    public Set<BillSupplement> getSupplements() {
        return supplements;
    }

    public void setSupplements(Set<BillSupplement> supplements) {
        this.supplements = supplements;
    }

    public Set<BillCalendar> getCalendars() {
        return calendars;
    }

    public void setCalendars(Set<BillCalendar> calendars) {
        this.calendars = calendars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(id, bill.id) &&
                Objects.equals(state, bill.state) &&
                Objects.equals(session, bill.session) &&
                Objects.equals(body, bill.body) &&
                Objects.equals(currentBody, bill.currentBody) &&
                Objects.equals(type, bill.type) &&
                Objects.equals(bill_number, bill.bill_number) &&
                status == bill.status &&
                Objects.equals(statusDate, bill.statusDate) &&
                Objects.equals(title, bill.title) &&
                Objects.equals(description, bill.description) &&
                Objects.equals(pendingCommittee, bill.pendingCommittee) &&
                Objects.equals(legiscanURL, bill.legiscanURL) &&
                Objects.equals(stateURL, bill.stateURL) &&
                Objects.equals(changeHash, bill.changeHash) &&
                Objects.equals(updated, bill.updated) &&
                Objects.equals(created, bill.created) &&
                Objects.equals(progress, bill.progress) &&
                Objects.equals(histories, bill.histories) &&
                Objects.equals(sponsors, bill.sponsors) &&
                Objects.equals(sasts, bill.sasts) &&
                Objects.equals(subjects, bill.subjects) &&
                Objects.equals(texts, bill.texts) &&
                Objects.equals(votes, bill.votes) &&
                Objects.equals(amendments, bill.amendments) &&
                Objects.equals(supplements, bill.supplements) &&
                Objects.equals(calendars, bill.calendars);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, state, session, body, currentBody, type, bill_number, status, statusDate, title, description, pendingCommittee, legiscanURL, stateURL, changeHash, updated, created, progress, histories, sponsors, sasts, subjects, texts, votes, amendments, supplements, calendars);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", state=" + state +
                ", session=" + session +
                ", body=" + body +
                ", currentBody=" + currentBody +
                ", type=" + type +
                ", bill_number='" + bill_number + '\'' +
                ", status=" + status +
                ", statusDate=" + statusDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pendingCommittee=" + pendingCommittee +
                ", legiscanURL=" + legiscanURL +
                ", stateURL=" + stateURL +
                ", changeHash='" + changeHash + '\'' +
                ", updated=" + updated +
                ", created=" + created +
                ", progress=" + progress +
                ", histories=" + histories +
                ", sponsors=" + sponsors +
                ", sasts=" + sasts +
                ", subjects=" + subjects +
                ", texts=" + texts +
                ", votes=" + votes +
                ", amendments=" + amendments +
                ", supplements=" + supplements +
                ", calendars=" + calendars +
                '}';
    }
}
