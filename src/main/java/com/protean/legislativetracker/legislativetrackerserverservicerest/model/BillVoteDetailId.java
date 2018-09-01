package com.protean.legislativetracker.legislativetrackerserverservicerest.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class BillVoteDetailId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roll_call_id")
    private BillVote rollCall;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "people_id")
    private Person person;

    public BillVoteDetailId() {
    }

    public BillVoteDetailId(BillVote rollCall
            , Person person
    ) {
        this.rollCall = rollCall;
//        this.person = person;
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
}
