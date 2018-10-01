
package com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.model;

import java.net.URL;
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
    "roll_call_id",
    "date",
    "desc",
    "yea",
    "nay",
    "nv",
    "absent",
    "total",
    "passed",
    "chamber",
    "chamber_id",
    "url",
    "state_link"
})
public class Vote {

    @JsonProperty("roll_call_id")
    private Integer voteId;
    @JsonProperty("date")
    private Date billVoteDate;
    @JsonProperty("desc")
    private String description;
    @JsonProperty("yea")
    private Integer yea;
    @JsonProperty("nay")
    private Integer nay;
    @JsonProperty("nv")
    private Integer nv;
    @JsonProperty("absent")
    private Integer absent;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("passed")
    private Integer passed;
    @JsonProperty("chamber")
    private String bodyAbbreviation;
    @JsonProperty("chamber_id")
    private Integer bodyId;
    @JsonProperty("url")
    private URL legiscanUrl;
    @JsonProperty("state_link")
    private URL stateUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Vote() {
    }

    /**
     * 
     * @param total
     * @param yea
     * @param description
     * @param voteId
     * @param passed
     * @param bodyId
     * @param absent
     * @param billVoteDate
     * @param stateUrl
     * @param legiscanUrl
     * @param nv
     * @param nay
     * @param bodyAbbreviation
     */
    public Vote(Integer voteId, Date billVoteDate, String description, Integer yea, Integer nay, Integer nv, Integer absent, Integer total, Integer passed, String bodyAbbreviation, Integer bodyId, URL legiscanUrl, URL stateUrl) {
        super();
        this.voteId = voteId;
        this.billVoteDate = billVoteDate;
        this.description = description;
        this.yea = yea;
        this.nay = nay;
        this.nv = nv;
        this.absent = absent;
        this.total = total;
        this.passed = passed;
        this.bodyAbbreviation = bodyAbbreviation;
        this.bodyId = bodyId;
        this.legiscanUrl = legiscanUrl;
        this.stateUrl = stateUrl;
    }

    @JsonProperty("roll_call_id")
    public Integer getVoteId() {
        return voteId;
    }

    @JsonProperty("roll_call_id")
    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    @JsonProperty("date")
    public Date getBillVoteDate() {
        return billVoteDate;
    }

    @JsonProperty("date")
    public void setBillVoteDate(Date billVoteDate) {
        this.billVoteDate = billVoteDate;
    }

    @JsonProperty("desc")
    public String getDescription() {
        return description;
    }

    @JsonProperty("desc")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("yea")
    public Integer getYea() {
        return yea;
    }

    @JsonProperty("yea")
    public void setYea(Integer yea) {
        this.yea = yea;
    }

    @JsonProperty("nay")
    public Integer getNay() {
        return nay;
    }

    @JsonProperty("nay")
    public void setNay(Integer nay) {
        this.nay = nay;
    }

    @JsonProperty("nv")
    public Integer getNv() {
        return nv;
    }

    @JsonProperty("nv")
    public void setNv(Integer nv) {
        this.nv = nv;
    }

    @JsonProperty("absent")
    public Integer getAbsent() {
        return absent;
    }

    @JsonProperty("absent")
    public void setAbsent(Integer absent) {
        this.absent = absent;
    }

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("passed")
    public Integer getPassed() {
        return passed;
    }

    @JsonProperty("passed")
    public void setPassed(Integer passed) {
        this.passed = passed;
    }

    @JsonProperty("chamber")
    public String getBodyAbbreviation() {
        return bodyAbbreviation;
    }

    @JsonProperty("chamber")
    public void setBodyAbbreviation(String bodyAbbreviation) {
        this.bodyAbbreviation = bodyAbbreviation;
    }

    @JsonProperty("chamber_id")
    public Integer getBodyId() {
        return bodyId;
    }

    @JsonProperty("chamber_id")
    public void setBodyId(Integer bodyId) {
        this.bodyId = bodyId;
    }

    @JsonProperty("url")
    public URL getLegiscanUrl() {
        return legiscanUrl;
    }

    @JsonProperty("url")
    public void setLegiscanUrl(URL legiscanUrl) {
        this.legiscanUrl = legiscanUrl;
    }

    @JsonProperty("state_link")
    public URL getStateUrl() {
        return stateUrl;
    }

    @JsonProperty("state_link")
    public void setStateUrl(URL stateUrl) {
        this.stateUrl = stateUrl;
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
