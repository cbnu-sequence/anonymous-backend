package com.sequence.anonymous.relation.presentation.dto;

import com.sequence.anonymous.relation.domain.Status;
import lombok.Getter;

@Getter
public class UpdateRequestDto {

  private Status status;

  protected UpdateRequestDto() {
  }
}
