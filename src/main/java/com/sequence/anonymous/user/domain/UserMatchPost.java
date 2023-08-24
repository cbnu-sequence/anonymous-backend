package com.sequence.anonymous.user.domain;

import jakarta.persistence.*;
@Entity
public class UserMatchPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userMatchPostId")
    private static Long id;

    @Column(name = "matchPostId")
    private Long matchPostId;

    @Column(name = "userId")
    private Long userId;

    @Column
    @Enumerated(EnumType.STRING)
    private UserMatchPostRole role;

}
