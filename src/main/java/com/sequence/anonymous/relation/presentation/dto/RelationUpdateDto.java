package com.sequence.anonymous.relation.presentation.dto;

import com.sequence.anonymous.relation.domain.RelationStatus;
import lombok.Getter;

@Getter
public class RelationUpdateDto {

  private RelationStatus status;
}
