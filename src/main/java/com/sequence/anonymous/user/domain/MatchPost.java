package com.sequence.anonymous.user.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class MatchPost {

    @Id
    @Column(name = "matchpost_id")
    private Long id;

    @OneToMany
    private List<UserMatchPost> usermatch_post = new ArrayList<>();

    private String title;

    private String introdue;

    private String appeal;

    @Enumerated(EnumType.STRING)
    private MatchPostStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
