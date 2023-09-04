package com.sequence.anonymous.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity @Getter
public class UserRelation {

    @Id
    @Column(name = "userRelation_id")
    private Long id;

    private Long user;
    private Long relation;

    // RelationKind ..?

    protected UserRelation(){

    }

    public UserRelation(Long user, Long relation) {
        this.user = user;
        this.relation = relation;
    }

    private UserRelation(Long id, Long user, Long relation){
        this.id = id;
        this.user = user;
        this.relation = relation;
    }
}
