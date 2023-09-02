package com.sequence.anonymous.user.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class UserMatchPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userMatchPost_id")
    private static Long id;

    @OneToMany
    @Column(name = "matchPost_id")
    private Long matchPostId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Long userId;

    @Column
    @Enumerated(EnumType.STRING)
    private UserMatchPostRole role;

    public UserMatchPost(Long matchPostId, Long userId, UserMatchPostRole role) {
        this.matchPostId = matchPostId;
        this.userId = userId;
        this.role = role;
    }
}
