package com.sequence.anonymous.user.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "college_id")
    private College college;

    @Column(unique = true, insertable = false, updatable = false, length = 10)
    @NotNull
    private String name;

    protected Department() {
    }

    @ManyToMany
    @JoinTable(schema = "College")
    private List<College> users = new ArrayList<>();
}
