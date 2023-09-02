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
    @Column(name = "matchPost_id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "title", nullable = false)
    private String introduce;

    @Column(name = "title", nullable = false)
    private String appeal;

    @Column
    @Enumerated(EnumType.STRING)
    private MatchPostStatus status;

    protected MatchPost() {
    }

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
