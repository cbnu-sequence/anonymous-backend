package com.sequence.anonymous.matchPost.domain;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
import com.google.common.base.Preconditions;
import com.sequence.anonymous.common.BaseTimeEntity;
import com.sequence.anonymous.matchPost.presentation.dto.MatchPostUpdateDto;
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

  @Column(nullable = false)
  private String title;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String introduce;

  private String appeal;

  @Enumerated(EnumType.STRING)
  private MatchPostStatus status;

  protected MatchPost() {
  }

  public MatchPost(String title, String introduce) {
    this(title, introduce, "No Data");
  }

  public MatchPost(String title, String introduce, String appeal) {
    this(null, title, introduce, appeal, MatchPostStatus.RECRUIT);
  }

  protected MatchPost(Long id, String title, String introduce, String appeal,
      MatchPostStatus status) {
    Preconditions.checkArgument(title != null, "title must be provided");
    Preconditions.checkArgument(introduce != null, "introduce must be provided");

    this.id = id;
    this.title = title;
    this.introduce = introduce;
    this.appeal = appeal;
    this.status = status;
  }

  public void updateMatchPost(MatchPostUpdateDto dto) {
    this.title = dto.getTitle();
    this.introduce = dto.getIntroduce();
    this.appeal = dto.getAppeal();
    this.status = dto.getStatus();
  }
}
