package com.sequence.anonymous.college.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private static Long id;

    @OneToOne
    @Column(name = "college_id")
    private Long collegeId;

    @Column
    private String name;
}
