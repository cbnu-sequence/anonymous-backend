package com.sequence.anonymous.college.presentation.dto;

import lombok.Getter;
import org.springframework.data.geo.Point;

@Getter
public class UpdateDto {

  private String name;

  private Point location;

  protected UpdateDto() {
  }
}
