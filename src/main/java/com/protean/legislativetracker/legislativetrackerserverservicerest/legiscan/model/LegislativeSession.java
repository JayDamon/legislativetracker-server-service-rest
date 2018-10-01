
package com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.annotations.LegiscanJsonName;
import com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.markerinterface.LegiscanOperationable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "session_id",
    "state_id",
    "session_name",
    "session_title",
    "year_start",
    "year_end",
    "special"
})
@LegiscanJsonName(name = "session")
public class LegislativeSession implements LegiscanOperationable {

    @JsonProperty("session_id")
    private Integer sessionId;
    @JsonProperty("state_id")
    private Integer stateId;
    @JsonProperty("session_name")
    private String sessionName;
    @JsonProperty("name")
    private String sessionTitle;
    @JsonProperty("year_start")
    private Integer yearStart;
    @JsonProperty("year_end")
    private Integer yearEnd;
    @JsonProperty("special")
    private Integer special;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     *
     */
    public LegislativeSession() {
    }

    /**
     *
     * @param sessionName
     * @param stateId
     * @param yearStart
     * @param sessionId
     * @param yearEnd
     * @param special
     * @param sessionTitle
     */
    public LegislativeSession(Integer sessionId, Integer stateId, String sessionName, String sessionTitle, Integer yearStart, Integer yearEnd, Integer special) {
        super();
        this.sessionId = sessionId;
        this.sessionName = sessionName;
        this.sessionTitle = sessionTitle;
        this.yearStart = yearStart;
        this.yearEnd = yearEnd;
        this.special = special;
    }

    @JsonProperty("session_id")
    public Integer getSessionId() {
        return sessionId;
    }

    @JsonProperty("session_id")
    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    @JsonProperty("state_id")
    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    @JsonProperty("session_name")
    public String getSessionName() {
        return sessionName;
    }

    @JsonProperty("session_name")
    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    @JsonProperty("session_title")
    public String getSessionTitle() {
        return sessionTitle;
    }

    @JsonProperty("session_title")
    public void setSessionTitle(String sessionTitle) {
        this.sessionTitle = sessionTitle;
    }

    @JsonProperty("year_start")
    public Integer getYearStart() {
        return yearStart;
    }

    @JsonProperty("year_start")
    public void setYearStart(Integer yearStart) {
        this.yearStart = yearStart;
    }

    @JsonProperty("year_end")
    public Integer getYearEnd() {
        return yearEnd;
    }

    @JsonProperty("year_end")
    public void setYearEnd(Integer yearEnd) {
        this.yearEnd = yearEnd;
    }

    @JsonProperty("special")
    public Integer getSpecial() {
        return special;
    }

    @JsonProperty("special")
    public void setSpecial(Integer special) {
        this.special = special;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
