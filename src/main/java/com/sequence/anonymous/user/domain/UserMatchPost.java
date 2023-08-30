package com.sequence.anonymous.user.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity @Getter
public class UserMatchPost {

    @Id
    @Column(name = "userMatchPost_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "matchpost_id")
    private MatchPost matchPost;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private UserMatchPostRole role;

}
