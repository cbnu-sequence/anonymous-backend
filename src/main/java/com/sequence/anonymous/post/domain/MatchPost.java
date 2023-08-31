package com.sequence.anonymous.post.domain;

import com.google.common.base.Preconditions;
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

    @Column
    private String title;

    @Column
    private String introduce;

    @Column
    private String appeal;

    @Column
    @Enumerated(EnumType.STRING)
    private MatchPostStatus status;

    public MatchPost(Long id, String title, String introduce, String appeal, MatchPostStatus status) {
        Preconditions.checkArgument(title != null, "title must be provided.");
        Preconditions.checkArgument(introduce != null, "introduce must be provided.");
        Preconditions.checkArgument(appeal != null, "appeal must be provided.");

        this.id = id;
        this.title = title;
        this.introduce = introduce;
        this.appeal = appeal;
        this.status = status;
    }
}
