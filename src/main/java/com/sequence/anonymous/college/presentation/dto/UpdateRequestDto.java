package com.sequence.anonymous.college.presentation.dto;

import lombok.Getter;
import org.springframework.data.geo.Point;

@Getter
public class UpdateRequestDto {

  private String name;

  private Point location;

  protected UpdateRequestDto() {
  }
}
