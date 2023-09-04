package com.sequence.anonymous.user.domain.college;

import com.sequence.anonymous.user.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Department {

    @Id
    @Column(name = "department_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "college_id")
    private College college;

    @OneToMany
    private List<User> user = new ArrayList<>();


    private String name;

}
