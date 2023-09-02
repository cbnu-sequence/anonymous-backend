package com.sequence.anonymous.relation.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relation_id")
    private static Long id;

    @OneToOne
    @JoinColumn(name = "user1_id")
    private Long user1Id;

    @OneToOne
    @JoinColumn(name = "user2_id")
    private Long user2Id;

    @Column
    private RelationStatus status;
}
