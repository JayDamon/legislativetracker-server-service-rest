package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "bill_vote_detail")
public class BillVoteDetail implements Serializable {

    @EmbeddedId
    private BillVoteDetailId id;

    @ManyToOne
    @JoinColumn(name = "roll_call_id", insertable = false, updatable = false)
    private BillVote rollCall;
    @ManyToOne
    @JoinColumn(name = "people_id", insertable = false, updatable = false)
    private Person person;
    @OneToOne
    @JoinColumn(name = "vote_id")
    private Vote vote;

    public BillVoteDetail() {
    }

    public BillVoteDetail(BillVote rollCall, Person person, Vote vote) {
        this.rollCall = rollCall;
        this.person = person;
        this.vote = vote;
        this.id = new BillVoteDetailId(rollCall
                , person
        );
    }

    public BillVoteDetailId getId() {
        return id;
    }

    public void setId(BillVoteDetailId id) {
        this.id = id;
    }

    public BillVote getRollCall() {
        return rollCall;
    }

    public void setRollCall(BillVote rollCall) {
        this.rollCall = rollCall;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillVoteDetail that = (BillVoteDetail) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(rollCall, that.rollCall) &&
                Objects.equals(person, that.person) &&
                Objects.equals(vote, that.vote);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, rollCall,
//                person,
                vote);
    }

    @Override
    public String toString() {
        return "BillVoteDetail{" +
                "id=" + id +
                ", rollCall=" + rollCall +
                ", person=" + person +
                ", vote=" + vote +
                '}';
    }
}
