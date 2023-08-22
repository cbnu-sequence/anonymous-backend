package com.sequence.anonymous.college.domain.presentation.dto;

import lombok.Getter;
import org.springframework.data.geo.Point;

@Getter
public class CollegeUpdateDto {

  private String name;

  private Point location;
}
