package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "person_id")
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    private State state;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "party_id")
    private Party party;
    @Column(name = "name")
    private String name;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "suffix")
    private String suffix;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "district")
    private String district;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "committee_sponsor_id")
    private Committee committee;
    @Column(name = "ballotpedia")
    private String ballotpedia;
    @Column(name = "followthemoney_eid")
    private Long followTheMoneyId;
    @Column(name = "votesmart_id")
    private Long voteSmartId;
    @Column(name = "opensecrets_id")
    private Long openSecretsId;
    @Column(name = "person_hash")
    private String personHash;
    @Column(name = "updated")
    private Calendar updated;
    @Column(name = "created")
    private Calendar created;

    @OneToMany(mappedBy = "person")
    private Set<BillVoteDetail> votes;

    public Person() {
    }

    public Person(Long id, State state, Role role, Party party, String name, String firstName, String middleName, String lastName, String suffix, String nickname, String district, Committee committee, String ballotpedia, Long followTheMoneyId, Long voteSmartId, Long openSecretsId, String personHash, Calendar updated, Calendar created) {
        this.id = id;
        this.state = state;
        this.role = role;
        this.party = party;
        this.name = name;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.nickname = nickname;
        this.district = district;
        this.committee = committee;
        this.ballotpedia = ballotpedia;
        this.followTheMoneyId = followTheMoneyId;
        this.voteSmartId = voteSmartId;
        this.openSecretsId = openSecretsId;
        this.personHash = personHash;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Committee getCommittee() {
        return committee;
    }

    public void setCommittee(Committee committee) {
        this.committee = committee;
    }

    public String getBallotpedia() {
        return ballotpedia;
    }

    public void setBallotpedia(String ballotpedia) {
        this.ballotpedia = ballotpedia;
    }

    public Long getFollowTheMoneyId() {
        return followTheMoneyId;
    }

    public void setFollowTheMoneyId(Long followTheMoneyId) {
        this.followTheMoneyId = followTheMoneyId;
    }

    public Long getVoteSmartId() {
        return voteSmartId;
    }

    public void setVoteSmartId(Long voteSmartId) {
        this.voteSmartId = voteSmartId;
    }

    public Long getOpenSecretsId() {
        return openSecretsId;
    }

    public void setOpenSecretsId(Long openSecretsId) {
        this.openSecretsId = openSecretsId;
    }

    public String getPersonHash() {
        return personHash;
    }

    public void setPersonHash(String personHash) {
        this.personHash = personHash;
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

    public Set<BillVoteDetail> getVotes() {
        return votes;
    }

    public void setVotes(Set<BillVoteDetail> votes) {
        this.votes = votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(state, person.state) &&
                Objects.equals(role, person.role) &&
                Objects.equals(party, person.party) &&
                Objects.equals(name, person.name) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(middleName, person.middleName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(suffix, person.suffix) &&
                Objects.equals(nickname, person.nickname) &&
                Objects.equals(district, person.district) &&
                Objects.equals(committee, person.committee) &&
                Objects.equals(ballotpedia, person.ballotpedia) &&
                Objects.equals(followTheMoneyId, person.followTheMoneyId) &&
                Objects.equals(voteSmartId, person.voteSmartId) &&
                Objects.equals(openSecretsId, person.openSecretsId) &&
                Objects.equals(personHash, person.personHash) &&
                Objects.equals(updated, person.updated) &&
                Objects.equals(created, person.created) &&
                Objects.equals(votes, person.votes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, state, role, party, name, firstName, middleName, lastName, suffix, nickname, district, committee, ballotpedia, followTheMoneyId, voteSmartId, openSecretsId, personHash, updated, created, votes);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", state=" + state +
                ", role=" + role +
                ", party=" + party +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", nickname='" + nickname + '\'' +
                ", district='" + district + '\'' +
                ", committee=" + committee +
                ", ballotpedia='" + ballotpedia + '\'' +
                ", followTheMoneyId=" + followTheMoneyId +
                ", voteSmartId=" + voteSmartId +
                ", openSecretsId=" + openSecretsId +
                ", personHash='" + personHash + '\'' +
                ", updated=" + updated +
                ", created=" + created +
                ", votes=" + votes +
                '}';
    }
}
