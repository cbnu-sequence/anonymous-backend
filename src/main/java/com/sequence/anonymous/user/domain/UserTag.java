package com.sequence.anonymous.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UserTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userTagId")
    private static Long id;

    @Column(name = "userId")
    private Long user;

    @Column(name = "tagId")
    private Long tagId;
}
