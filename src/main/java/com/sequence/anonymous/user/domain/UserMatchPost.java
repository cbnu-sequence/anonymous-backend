package com.sequence.anonymous.user.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class UserMatchPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userMatchPostId")
    private static Long id;

    @Column(name = "matchPostId")
    private Long matchPostId;

    @ManyToOne
    @JoinColumn(name = "userId")
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
