package com.sequence.anonymous.post.domain;

import com.sequence.anonymous.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class MatchPost extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matchPostId")
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column
    private String title;

    @Column
    private String introduce;

    @Column
    private String appeal;

    @Column
    @Enumerated(EnumType.STRING)
    private MatchPostStatus status;


}
