package com.sequence.anonymous.college.domain;

import com.google.common.base.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.geo.Point;

@Entity
@Getter
public class College {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  private Point location;

  protected College() {
  }

  public College(String name, Point location) {
    Preconditions.checkArgument(name != null, "name must be provided");
    Preconditions.checkArgument(location != null, "location must be provided");

    this.id = null;
    this.name = name;
    this.location = location;
  }

  public void updateName(String name) {
    Preconditions.checkArgument(name != null, "name must be provided");

    this.name = name;
  }
}
