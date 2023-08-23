package com.sequence.anonymous.matchpost.presentation.dto;

import com.sequence.anonymous.matchpost.domain.Status;
import lombok.Getter;

@Getter
public class UpdateDto {

  private String title;

  private String introduce;

  private String appeal;

  private Status status;
}
