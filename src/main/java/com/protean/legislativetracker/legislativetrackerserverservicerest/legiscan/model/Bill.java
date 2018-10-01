
package com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.model;

import java.net.URL;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.markerinterface.LegiscanOperationable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bill_id",
    "change_hash",
    "session_id",
    "session",
    "url",
    "state_link",
    "completed",
    "statusId",
    "status_date",
    "progress",
    "state",
    "state_id",
    "bill_number",
    "bill_type",
    "bill_type_id",
    "body",
    "body_id",
    "current_body",
    "current_body_id",
    "title",
    "description",
    "committee",
    "pending_committee_id",
    "history",
    "sponsors",
    "sasts",
    "subjects",
    "texts",
    "votes",
    "amendments",
    "supplements",
    "calendar"
})
public class Bill implements LegiscanOperationable {

    @JsonProperty("bill_id")
    private Long billId;
    @JsonProperty("change_hash")
    private String changeHash;
    @JsonProperty("session_id")
    private Integer sessionId;
    @JsonProperty("session")
    private LegislativeSession legislativeSession;
    @JsonProperty("url")
    private URL legiscanUrl;
    @JsonProperty("state_link")
    private URL stateLink;
    @JsonProperty("status")
    private Integer statusId;
    @JsonProperty("status_date")
    private Date statusDate;
    @JsonProperty("state")
    private String stateName;
    @JsonProperty("state_id")
    private Integer stateId;
    @JsonProperty("bill_number")
    private String billNumber;
    @JsonProperty("bill_type")
    private String billTypeAbbreviation;
    @JsonProperty("bill_type_id")
    private String billTypeId;
    @JsonProperty("body")
    private String bodyShort;
    @JsonProperty("body_id")
    private Integer bodyId;
    @JsonProperty("current_body")
    private String currentBodyShort;
    @JsonProperty("current_body_id")
    private Integer currentBodyId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("pending_committee_id")
    private Integer pendingCommitteeId;
    @JsonProperty("progress")
    private List<Progress> progress = null;
    @JsonProperty("committee")
    private Set<Object> committee = null; //ToDo find good bill to test this
    @JsonProperty("history")
    private Set<History> histories = null;
    @JsonProperty("sponsors")
    private Set<Sponsor> sponsors = null;
    @JsonProperty("sasts")
    private Set<Bill> sasts = null; //ToDo find better bill to test with this
    @JsonProperty("subjects")
    private Set<Subject> subjects = null;
    @JsonProperty("texts")
    private Set<Text> texts = null;
    @JsonProperty("votes")
    private Set<Vote> votes = null;
    @JsonProperty("amendments") //ToDo find better bill to test with this
    private Set<Object> amendments = null;  //ToDo create AmendmentObject
    @JsonProperty("supplements") //ToDo find better bill to test with this
    private Set<Object> supplements = null; //ToDo create SupplementObject
    @JsonProperty("calendar")
    private Set<Calendar> calendars = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Bill() {
    }

    /**
     *
     * @param progress
     * @param bodyShort
     * @param currentBodyId
     * @param subjects
     * @param billNumber
     * @param votes
     * @param stateName
     * @param statusDate
     * @param bodyId
     * @param pendingCommitteeId
     * @param currentBodyShort
     * @param billTypeId
     * @param title
     * @param description
     * @param billId
     * @param supplements
     * @param calendars
     * @param completed
     * @param texts
     * @param billTypeAbbreviation
     * @param statusId
     * @param sasts
     * @param changeHash
     * @param stateLink
     * @param legiscanUrl
     * @param histories
     * @param amendments
     * @param committee
     * @param legislativeSession
     * @param sessionId
     * @param sponsors
     * @param stateId
     */
    public Bill(Long billId, String changeHash, Integer sessionId, LegislativeSession legislativeSession, URL legiscanUrl, URL stateLink, Integer completed, Integer statusId, java.sql.Date statusDate, List<Progress> progress, String stateName, Integer stateId, String billNumber, String billTypeAbbreviation, String billTypeId, String bodyShort, Integer bodyId, String currentBodyShort, Integer currentBodyId, String title, String description, Set<Object> committee, Integer pendingCommitteeId, Set<History> histories, Set<Sponsor> sponsors, Set<Bill> sasts, Set<Subject> subjects, Set<Text> texts, Set<Vote> votes, Set<Object> amendments, Set<Object> supplements, Set<Calendar> calendars) {
        super();
        this.billId = billId;
        this.changeHash = changeHash;
        this.sessionId = sessionId;
        this.legislativeSession = legislativeSession;
        this.legiscanUrl = legiscanUrl;
        this.stateLink = stateLink;
        this.statusId = statusId;
        this.statusDate = statusDate;
        this.progress = progress;
        this.stateName = stateName;
        this.stateId = stateId;
        this.billNumber = billNumber;
        this.billTypeAbbreviation = billTypeAbbreviation;
        this.billTypeId = billTypeId;
        this.bodyShort = bodyShort;
        this.bodyId = bodyId;
        this.currentBodyShort = currentBodyShort;
        this.currentBodyId = currentBodyId;
        this.title = title;
        this.description = description;
        this.committee = committee;
        this.pendingCommitteeId = pendingCommitteeId;
        this.histories = histories;
        this.sponsors = sponsors;
        this.sasts = sasts;
        this.subjects = subjects;
        this.texts = texts;
        this.votes = votes;
        this.amendments = amendments;
        this.supplements = supplements;
        this.calendars = calendars;
    }

    @JsonProperty("bill_id")
    public Long getBillId() {
        return billId;
    }

    @JsonProperty("bill_id")
    public void setBillId(Long billId) {
        this.billId = billId;
    }

    @JsonProperty("change_hash")
    public String getChangeHash() {
        return changeHash;
    }

    @JsonProperty("change_hash")
    public void setChangeHash(String changeHash) {
        this.changeHash = changeHash;
    }

    @JsonProperty("session_id")
    public Integer getSessionId() {
        return sessionId;
    }

    @JsonProperty("session_id")
    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    @JsonProperty("session")
    public LegislativeSession getLegislativeSession() {
        return legislativeSession;
    }

    @JsonProperty("legislativeSession")
    public void setLegislativeSession(LegislativeSession legislativeSession) {
        this.legislativeSession = legislativeSession;
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
    public URL getStateLink() {
        return stateLink;
    }

    @JsonProperty("state_link")
    public void setStateLink(URL stateLink) {
        this.stateLink = stateLink;
    }

    @JsonProperty("status")
    public Integer getStatusId() {
        return statusId;
    }

    @JsonProperty("status")
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @JsonProperty("status_date")
    public Date getStatusDate() {
        return statusDate;
    }

    @JsonProperty("status_date")
    public void setStatusDate(java.sql.Date statusDate) {
        this.statusDate = statusDate;
    }

    @JsonProperty("progress")
    public List<Progress> getProgress() {
        return progress;
    }

    @JsonProperty("progress")
    public void setProgress(List<Progress> progress) {
        this.progress = progress;
    }

    @JsonProperty("state")
    public String getStateName() {
        return stateName;
    }

    @JsonProperty("state")
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @JsonProperty("state_id")
    public Integer getStateId() {
        return stateId;
    }

    @JsonProperty("state_id")
    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    @JsonProperty("bill_number")
    public String getBillNumber() {
        return billNumber;
    }

    @JsonProperty("bill_number")
    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    @JsonProperty("bill_type")
    public String getBillTypeAbbreviation() {
        return billTypeAbbreviation;
    }

    @JsonProperty("bill_type")
    public void setBillTypeAbbreviation(String billTypeAbbreviation) {
        this.billTypeAbbreviation = billTypeAbbreviation;
    }

    @JsonProperty("bill_type_id")
    public String getBillTypeId() {
        return billTypeId;
    }

    @JsonProperty("bill_type_id")
    public void setBillTypeId(String billTypeId) {
        this.billTypeId = billTypeId;
    }

    @JsonProperty("body")
    public String getBodyShort() {
        return bodyShort;
    }

    @JsonProperty("body")
    public void setBodyShort(String bodyShort) {
        this.bodyShort = bodyShort;
    }

    @JsonProperty("body_id")
    public Integer getBodyId() {
        return bodyId;
    }

    @JsonProperty("body_id")
    public void setBodyId(Integer bodyId) {
        this.bodyId = bodyId;
    }

    @JsonProperty("current_body")
    public String getCurrentBodyShort() {
        return currentBodyShort;
    }

    @JsonProperty("current_body")
    public void setCurrentBodyShort(String currentBodyShort) {
        this.currentBodyShort = currentBodyShort;
    }

    @JsonProperty("current_body_id")
    public Integer getCurrentBodyId() {
        return currentBodyId;
    }

    @JsonProperty("current_body_id")
    public void setCurrentBodyId(Integer currentBodyId) {
        this.currentBodyId = currentBodyId;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("committee")
    public Set<Object> getCommittee() {
        return committee;
    }

    @JsonProperty("committee")
    public void setCommittee(Set<Object> committee) {
        this.committee = committee;
    }

    @JsonProperty("pending_committee_id")
    public Integer getPendingCommitteeId() {
        return pendingCommitteeId;
    }

    @JsonProperty("pending_committee_id")
    public void setPendingCommitteeId(Integer pendingCommitteeId) {
        this.pendingCommitteeId = pendingCommitteeId;
    }

    @JsonProperty("history")
    public Set<History> getHistories() {
        return histories;
    }

    @JsonProperty("history")
    public void setHistories(Set<History> histories) {
        this.histories = histories;
    }

    @JsonProperty("sponsors")
    public Set<Sponsor> getSponsors() {
        return sponsors;
    }

    @JsonProperty("sponsors")
    public void setSponsors(Set<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }

    @JsonProperty("sasts")
    public Set<Bill> getSasts() {
        return sasts;
    }

    @JsonProperty("sasts")
    public void setSasts(Set<Bill> sasts) {
        this.sasts = sasts;
    }

    @JsonProperty("subjects")
    public Set<Subject> getSubjects() {
        return subjects;
    }

    @JsonProperty("subjects")
    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @JsonProperty("texts")
    public Set<Text> getTexts() {
        return texts;
    }

    @JsonProperty("texts")
    public void setTexts(Set<Text> texts) {
        this.texts = texts;
    }

    @JsonProperty("votes")
    public Set<Vote> getVotes() {
        return votes;
    }

    @JsonProperty("votes")
    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }

    @JsonProperty("amendments")
    public Set<Object> getAmendments() {
        return amendments;
    }

    @JsonProperty("amendments")
    public void setAmendments(Set<Object> amendments) {
        this.amendments = amendments;
    }

    @JsonProperty("supplements")
    public Set<Object> getSupplements() {
        return supplements;
    }

    @JsonProperty("supplements")
    public void setSupplements(Set<Object> supplements) {
        this.supplements = supplements;
    }

    @JsonProperty("calendar")
    public Set<Calendar> getCalendars() {
        return calendars;
    }

    @JsonProperty("calendar")
    public void setCalendars(Set<Calendar> calendars) {
        this.calendars = calendars;
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
