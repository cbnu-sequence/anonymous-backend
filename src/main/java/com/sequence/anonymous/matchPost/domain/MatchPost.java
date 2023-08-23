package com.sequence.anonymous.matchpost.domain;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.common.BaseTimeEntity;
import com.sequence.anonymous.matchpost.presentation.dto.UpdateDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class MatchPost extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 40, nullable = false)
  private String title;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String introduce;

  @Column(length = 50)
  private String appeal;

  @Column(length = 10)
  @Enumerated(EnumType.STRING)
  private Status status;

  protected MatchPost() {
  }

  public MatchPost(String title, String introduce) {
    this(title, introduce, "No Data");
  }

  public MatchPost(String title, String introduce, String appeal) {
    this(null, title, introduce, appeal, Status.RECRUIT);
  }

  protected MatchPost(Long id, String title, String introduce, String appeal,
      Status status) {
    Preconditions.checkArgument(title != null, "title must be provided");
    Preconditions.checkArgument(introduce != null, "introduce must be provided");
    Preconditions.checkArgument(appeal != null, "appeal must be provided");
    Preconditions.checkArgument(status != null, "status must be provided");

    this.id = id;
    this.title = title;
    this.introduce = introduce;
    this.appeal = appeal;
    this.status = status;
  }

  public void updateMatchPost(UpdateDto dto) {
    this.title = dto.getTitle();
    this.introduce = dto.getIntroduce();
    this.appeal = dto.getAppeal();
    this.status = dto.getStatus();
  }
}