package com.sequence.anonymous.matchpost.domain;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@Entity
public class MatchPost extends BaseEntity {

  @NotNull
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50)
  @NotNull
  private String title;

  @Column(length = 50)
  @NotNull
  private String introduce;

  @Column(length = 50)
  @NotNull
  private String appeal;

  @Enumerated(EnumType.STRING)
  @Column(length = 10)
  @NotNull
  private Status status;

  protected MatchPost() {
  }

  public MatchPost(String title, String introduce, String appeal) {
    this(null, title, introduce, appeal, Status.RECRUIT);
  }

  private MatchPost(Long id, String title, String introduce, String appeal, Status status) {
    Preconditions.checkArgument(title != null, "title must be provided.");
    Preconditions.checkArgument(introduce != null, "introduce must be provided.");
    Preconditions.checkArgument(appeal != null, "appeal must be provided.");
    Preconditions.checkArgument(status != null, "status must be provided.");

    Preconditions.checkArgument(title.isEmpty(), "title must not be empty.");

    this.id = id;
    this.title = title;
    this.introduce = introduce;
    this.appeal = appeal;
    this.status = status;
  }
}
