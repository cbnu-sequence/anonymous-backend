package com.sequence.anonymous.tag.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tagId")
    private static Long id;

    @Column
    private String name;


}
