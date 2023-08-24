package com.sequence.anonymous.relation.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relationId")
    private static Long id;

    @Column(name = "user1Id")
    private Long user1Id;

    @Column(name = "user2Id")
    private Long user2Id;

    @Column
    private RelationStatus status;
}
