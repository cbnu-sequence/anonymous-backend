package com.sequence.anonymous.user.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class UserTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userTagId")
    private static Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Long user;

    @ManyToOne
    @JoinColumn(name = "tagId")
    private Long tagId;

    public UserTag(Long user, Long tagId) {
        this.user = user;
        this.tagId = tagId;
    }
}
