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
    @Column(name = "session_hash", nullable = false)
    private String sessionHash;

    public LegislativeSession() {
    }

    public LegislativeSession(Integer sessionId, State state, Integer yearStart, Integer yearEnd, Boolean special, String sessionName, String sessionTitle, String sessionHash) {
        this.sessionId = sessionId;
        this.state = state;
        this.yearStart = yearStart;
        this.yearEnd = yearEnd;
        this.special = special;
        this.sessionName = sessionName;
        this.sessionTitle = sessionTitle;
        this.sessionHash = sessionHash;
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

    public String getSessionHash() {
        return sessionHash;
    }

    public void setSessionHash(String sessionHash) {
        this.sessionHash = sessionHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LegislativeSession that = (LegislativeSession) o;
        return Objects.equals(sessionId, that.sessionId) &&
                Objects.equals(state, that.state) &&
                Objects.equals(yearStart, that.yearStart) &&
                Objects.equals(yearEnd, that.yearEnd) &&
                Objects.equals(special, that.special) &&
                Objects.equals(sessionName, that.sessionName) &&
                Objects.equals(sessionTitle, that.sessionTitle) &&
                Objects.equals(sessionHash, that.sessionHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId, state, yearStart, yearEnd, special, sessionName, sessionTitle, sessionHash);
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
                ", sessionHash='" + sessionHash + '\'' +
                '}';
    }
}
