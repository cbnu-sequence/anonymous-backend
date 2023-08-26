package com.sequence.anonymous.invite.presentation.dto;

import com.sequence.anonymous.invite.domain.Status;
import lombok.Getter;

@Getter
public class UpdateDto {

  private Status status;

  protected UpdateDto() {
  }
}
