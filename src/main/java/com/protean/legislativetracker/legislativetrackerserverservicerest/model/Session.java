package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "session")
public class Session {
    @Id
    @Column(name = "session_id")
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    private State state;
    @Column(name = "year_start", nullable = false)
    private Date yearStart;
    @Column(name = "year_end", nullable = false)
    private Date yearEnd;
    @Column(name = "special", nullable = false)
    private Boolean special;
    @Column(name = "session_name", nullable = false)
    private String sessionName;
    @Column(name = "session_title", nullable = false)
    private String sessionTitle;

    public Session() {
    }

    public Session(Integer id, State state, Date yearStart, Date yearEnd, Boolean special, String sessionName, String sessionTitle) {
        this.id = id;
        this.state = state;
        this.yearStart = yearStart;
        this.yearEnd = yearEnd;
        this.special = special;
        this.sessionName = sessionName;
        this.sessionTitle = sessionTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Date getYearStart() {
        return yearStart;
    }

    public void setYearStart(Date yearStart) {
        this.yearStart = yearStart;
    }

    public Date getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(Date yearEnd) {
        this.yearEnd = yearEnd;
    }

    public Boolean getSpecial() {
        return special;
    }

    public void setSpecial(Boolean special) {
        this.special = special;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionTitle() {
        return sessionTitle;
    }

    public void setSessionTitle(String sessionTitle) {
        this.sessionTitle = sessionTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(id, session.id) &&
                Objects.equals(state, session.state) &&
                Objects.equals(yearStart, session.yearStart) &&
                Objects.equals(yearEnd, session.yearEnd) &&
                Objects.equals(special, session.special) &&
                Objects.equals(sessionName, session.sessionName) &&
                Objects.equals(sessionTitle, session.sessionTitle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, state, yearStart, yearEnd, special, sessionName, sessionTitle);
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", state=" + state +
                ", yearStart=" + yearStart +
                ", yearEnd=" + yearEnd +
                ", special=" + special +
                ", sessionName='" + sessionName + '\'' +
                ", sessionTitle='" + sessionTitle + '\'' +
                '}';
    }
}
