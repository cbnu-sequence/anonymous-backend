package com.sequence.anonymous.user.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "College")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "college_id")
    private Long id;

    @Column(unique = true, length = 10)
    @NotNull
    private String name;

    @OneToMany(mappedBy = "college")
    private List<Department> departments = new ArrayList<>();

    protected College() {
    }

}
