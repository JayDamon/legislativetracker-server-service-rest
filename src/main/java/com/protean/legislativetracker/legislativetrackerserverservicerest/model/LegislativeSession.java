package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.markerinterface.LegiscanOperationable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "session")
public class LegislativeSession implements LegiscanOperationable {
    @Id
    @Column(name = "session_id")
    @JsonProperty("session_id")
    private Integer sessionId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    private State state;
    @Column(name = "year_start", nullable = false)
    @JsonProperty("year_start")
    private Integer yearStart;
    @Column(name = "year_end", nullable = false)
    @JsonProperty("year_end")
    private Integer yearEnd;
    @Column(name = "special", nullable = false)
    @JsonProperty("special")
    private Boolean special;
    @Column(name = "session_name", nullable = false)
    @JsonProperty("session_name")
    private String sessionName;
    @Column(name = "session_title", nullable = false)
    @JsonProperty("session_title")
    private String sessionTitle;

    public LegislativeSession() {
    }

    public LegislativeSession(Integer sessionId, State state, Integer yearStart, Integer yearEnd, Boolean special, String sessionName, String sessionTitle) {
        this.sessionId = sessionId;
        this.state = state;
        this.yearStart = yearStart;
        this.yearEnd = yearEnd;
        this.special = special;
        this.sessionName = sessionName;
        this.sessionTitle = sessionTitle;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Integer getYearStart() {
        return yearStart;
    }

    public void setYearStart(Integer yearStart) {
        this.yearStart = yearStart;
    }

    public Integer getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(Integer yearEnd) {
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
        LegislativeSession legislativeSession = (LegislativeSession) o;
        return Objects.equals(sessionId, legislativeSession.sessionId) &&
                Objects.equals(state, legislativeSession.state) &&
                Objects.equals(yearStart, legislativeSession.yearStart) &&
                Objects.equals(yearEnd, legislativeSession.yearEnd) &&
                Objects.equals(special, legislativeSession.special) &&
                Objects.equals(sessionName, legislativeSession.sessionName) &&
                Objects.equals(sessionTitle, legislativeSession.sessionTitle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sessionId, state, yearStart, yearEnd, special, sessionName, sessionTitle);
    }

    @Override
    public String toString() {
        return "LegislativeSession{" +
                "sessionId=" + sessionId +
                ", state=" + state +
                ", yearStart=" + yearStart +
                ", yearEnd=" + yearEnd +
                ", special=" + special +
                ", sessionName='" + sessionName + '\'' +
                ", sessionTitle='" + sessionTitle + '\'' +
                '}';
    }
}
