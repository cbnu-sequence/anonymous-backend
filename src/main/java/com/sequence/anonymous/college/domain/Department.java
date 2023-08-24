package com.sequence.anonymous.college.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmentId")
    private static Long id;

    @Column(name = "collegeId")
    private Long collegeId;
    @Column
    private String name;
}
