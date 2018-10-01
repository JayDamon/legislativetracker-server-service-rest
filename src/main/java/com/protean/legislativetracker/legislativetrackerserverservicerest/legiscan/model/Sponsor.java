
package com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@SuppressWarnings("ALL")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "people_id",
    "person_hash",
    "party_id",
    "party",
    "role_id",
    "role",
    "name",
    "first_name",
    "middle_name",
    "last_name",
    "suffix",
    "nickname",
    "district",
    "ftm_eid",
    "votesmart_id",
    "opensecrets_id",
    "ballotpedia",
    "sponsor_type_id",
    "sponsor_order",
    "committee_sponsor",
    "committee_id"
})
public class Sponsor {

    @JsonProperty("people_id")
    private Integer personId;
    @JsonProperty("person_hash")
    private String personHash;
    @JsonProperty("party_id")
    private Integer personPartyId;
    @JsonProperty("party")
    private String personPartyAbbreviation;
    @JsonProperty("role_id")
    private Integer personRoleId;
    @JsonProperty("role")
    private String personRoleAbbreviation;
    @JsonProperty("name")
    private String personName;
    @JsonProperty("first_name")
    private String personFirstName;
    @JsonProperty("middle_name")
    private String personMiddleName;
    @JsonProperty("last_name")
    private String personLastName;
    @JsonProperty("suffix")
    private String personSuffix;
    @JsonProperty("nickname")
    private String personNickname;
    @JsonProperty("district")
    private String personDistrict;
    @JsonProperty("ftm_eid")
    private Integer personFollowTheMoneyId;
    @JsonProperty("votesmart_id")
    private Integer personVotesmartId;
    @JsonProperty("opensecrets_id")
    private String personOpensecretsId;
    @JsonProperty("ballotpedia")
    private String personBallotpedia;
    @JsonProperty("sponsor_type_id")
    private Integer sponsorTypeId;
    @JsonProperty("sponsor_order")
    private Integer idSponsorOrder;
    @JsonProperty("committee_sponsor")
    private Integer committeeSponsor;
    @JsonProperty("committee_id")
    private String committeeId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Sponsor() {
    }

    /**
     * 
     * @param personMiddleName
     * @param personVotesmartId
     * @param personLastName
     * @param personFollowTheMoneyId
     * @param personId
     * @param personNickname
     * @param personPartyAbbreviation
     * @param personSuffix
     * @param committeeId
     * @param sponsorTypeId
     * @param personBallotpedia
     * @param personPartyId
     * @param personHash
     * @param personName
     * @param idSponsorOrder
     * @param personRoleAbbreviation
     * @param committeeSponsor
     * @param personOpensecretsId
     * @param personDistrict
     * @param personFirstName
     * @param personRoleId
     */
    public Sponsor(Integer personId, String personHash, Integer personPartyId, String personPartyAbbreviation, Integer personRoleId, String personRoleAbbreviation, String personName, String personFirstName, String personMiddleName, String personLastName, String personSuffix, String personNickname, String personDistrict, Integer personFollowTheMoneyId, Integer personVotesmartId, String personOpensecretsId, String personBallotpedia, Integer sponsorTypeId, Integer idSponsorOrder, Integer committeeSponsor, String committeeId) {
        super();
        this.personId = personId;
        this.personHash = personHash;
        this.personPartyId = personPartyId;
        this.personPartyAbbreviation = personPartyAbbreviation;
        this.personRoleId = personRoleId;
        this.personRoleAbbreviation = personRoleAbbreviation;
        this.personName = personName;
        this.personFirstName = personFirstName;
        this.personMiddleName = personMiddleName;
        this.personLastName = personLastName;
        this.personSuffix = personSuffix;
        this.personNickname = personNickname;
        this.personDistrict = personDistrict;
        this.personFollowTheMoneyId = personFollowTheMoneyId;
        this.personVotesmartId = personVotesmartId;
        this.personOpensecretsId = personOpensecretsId;
        this.personBallotpedia = personBallotpedia;
        this.sponsorTypeId = sponsorTypeId;
        this.idSponsorOrder = idSponsorOrder;
        this.committeeSponsor = committeeSponsor;
        this.committeeId = committeeId;
    }

    @JsonProperty("people_id")
    public Integer getPersonId() {
        return personId;
    }

    @JsonProperty("people_id")
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @JsonProperty("person_hash")
    public String getPersonHash() {
        return personHash;
    }

    @JsonProperty("person_hash")
    public void setPersonHash(String personHash) {
        this.personHash = personHash;
    }

    @JsonProperty("party_id")
    public Integer getPersonPartyId() {
        return personPartyId;
    }

    @JsonProperty("party_id")
    public void setPersonPartyId(Integer personPartyId) {
        this.personPartyId = personPartyId;
    }

    @JsonProperty("party")
    public String getPersonPartyAbbreviation() {
        return personPartyAbbreviation;
    }

    @JsonProperty("party")
    public void setPersonPartyAbbreviation(String personPartyAbbreviation) {
        this.personPartyAbbreviation = personPartyAbbreviation;
    }

    @JsonProperty("role_id")
    public Integer getPersonRoleId() {
        return personRoleId;
    }

    @JsonProperty("role_id")
    public void setPersonRoleId(Integer personRoleId) {
        this.personRoleId = personRoleId;
    }

    @JsonProperty("role")
    public String getPersonRoleAbbreviation() {
        return personRoleAbbreviation;
    }

    @JsonProperty("role")
    public void setPersonRoleAbbreviation(String personRoleAbbreviation) {
        this.personRoleAbbreviation = personRoleAbbreviation;
    }

    @JsonProperty("name")
    public String getPersonName() {
        return personName;
    }

    @JsonProperty("name")
    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @JsonProperty("first_name")
    public String getPersonFirstName() {
        return personFirstName;
    }

    @JsonProperty("first_name")
    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    @JsonProperty("middle_name")
    public String getPersonMiddleName() {
        return personMiddleName;
    }

    @JsonProperty("middle_name")
    public void setPersonMiddleName(String personMiddleName) {
        this.personMiddleName = personMiddleName;
    }

    @JsonProperty("last_name")
    public String getPersonLastName() {
        return personLastName;
    }

    @JsonProperty("last_name")
    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    @JsonProperty("suffix")
    public String getPersonSuffix() {
        return personSuffix;
    }

    @JsonProperty("suffix")
    public void setPersonSuffix(String personSuffix) {
        this.personSuffix = personSuffix;
    }

    @JsonProperty("nickname")
    public String getPersonNickname() {
        return personNickname;
    }

    @JsonProperty("nickname")
    public void setPersonNickname(String personNickname) {
        this.personNickname = personNickname;
    }

    @JsonProperty("district")
    public String getPersonDistrict() {
        return personDistrict;
    }

    @JsonProperty("district")
    public void setPersonDistrict(String personDistrict) {
        this.personDistrict = personDistrict;
    }

    @JsonProperty("ftm_eid")
    public Integer getPersonFollowTheMoneyId() {
        return personFollowTheMoneyId;
    }

    @JsonProperty("ftm_eid")
    public void setPersonFollowTheMoneyId(Integer personFollowTheMoneyId) {
        this.personFollowTheMoneyId = personFollowTheMoneyId;
    }

    @JsonProperty("votesmart_id")
    public Integer getPersonVotesmartId() {
        return personVotesmartId;
    }

    @JsonProperty("votesmart_id")
    public void setPersonVotesmartId(Integer personVotesmartId) {
        this.personVotesmartId = personVotesmartId;
    }

    @JsonProperty("opensecrets_id")
    public String getPersonOpensecretsId() {
        return personOpensecretsId;
    }

    @JsonProperty("opensecrets_id")
    public void setPersonOpensecretsId(String personOpensecretsId) {
        this.personOpensecretsId = personOpensecretsId;
    }

    @JsonProperty("ballotpedia")
    public String getPersonBallotpedia() {
        return personBallotpedia;
    }

    @JsonProperty("ballotpedia")
    public void setPersonBallotpedia(String personBallotpedia) {
        this.personBallotpedia = personBallotpedia;
    }

    @JsonProperty("sponsor_type_id")
    public Integer getSponsorTypeId() {
        return sponsorTypeId;
    }

    @JsonProperty("sponsor_type_id")
    public void setSponsorTypeId(Integer sponsorTypeId) {
        this.sponsorTypeId = sponsorTypeId;
    }

    @JsonProperty("sponsor_order")
    public Integer getIdSponsorOrder() {
        return idSponsorOrder;
    }

    @JsonProperty("sponsor_order")
    public void setIdSponsorOrder(Integer idSponsorOrder) {
        this.idSponsorOrder = idSponsorOrder;
    }

    @JsonProperty("committee_sponsor")
    public Integer getCommitteeSponsor() {
        return committeeSponsor;
    }

    @JsonProperty("committee_sponsor")
    public void setCommitteeSponsor(Integer committeeSponsor) {
        this.committeeSponsor = committeeSponsor;
    }

    @JsonProperty("committee_id")
    public String getCommitteeId() {
        return committeeId;
    }

    @JsonProperty("committee_id")
    public void setCommitteeId(String committeeId) {
        this.committeeId = committeeId;
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
