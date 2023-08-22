package com.sequence.anonymous.matchPost.presentation.dto;

import com.sequence.anonymous.matchPost.domain.MatchPostStatus;
import lombok.Getter;

@Getter
public class MatchPostUpdateDto {

  private String title;

  private String introduce;

  private String appeal;

  private MatchPostStatus status;
}
