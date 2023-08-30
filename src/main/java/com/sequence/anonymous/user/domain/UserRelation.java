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
}
