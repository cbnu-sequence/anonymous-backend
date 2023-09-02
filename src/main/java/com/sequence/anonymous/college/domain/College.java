package com.sequence.anonymous.college.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "college_id")
    private static Long id;

    @Column
    private String name;


}
