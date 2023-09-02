package com.sequence.anonymous.user.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class UserTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userTag_id")
    private static Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Long user;

    @OneToMany
    @JoinColumn(name = "tag_id")
    private Long tagId;

    public UserTag(Long user, Long tagId) {
        this.user = user;
        this.tagId = tagId;
    }
}
