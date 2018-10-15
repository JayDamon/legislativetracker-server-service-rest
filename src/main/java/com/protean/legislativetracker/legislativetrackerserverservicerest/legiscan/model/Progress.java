
package com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date",
        "event"
})
public class Progress {

    @JsonProperty("date")
    private Date progressDate;
    @JsonProperty("event")
    private Integer progressEventId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     */
    public Progress() {
    }

    /**
     * @param progressEventId
     * @param progressDate
     */
    public Progress(Date progressDate, Integer progressEventId) {
        super();
        this.progressDate = progressDate;
        this.progressEventId = progressEventId;
    }

    @JsonProperty("date")
    public Date getProgressDate() {
        return progressDate;
    }

    @JsonProperty("progressDate")
    public void setProgressDate(Date progressDate) {
        this.progressDate = progressDate;
    }

    @JsonProperty("event")
    public Integer getProgressEventId() {
        return progressEventId;
    }

    @JsonProperty("progressEventId")
    public void setProgressEventId(Integer progressEventId) {
        this.progressEventId = progressEventId;
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
