package com.sequence.anonymous.user.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@Entity
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, insertable = false, updatable = false, length = 10)
    @NotNull
    private String name;

    protected College() {
    }

}
