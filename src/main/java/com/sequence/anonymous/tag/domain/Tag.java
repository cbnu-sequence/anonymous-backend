package com.sequence.anonymous.tag.domain;

import com.google.common.base.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Tag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  protected Tag() {
  }

  public Tag(String name) {
    Preconditions.checkArgument(name != null, "name must be provided");

    this.id = null;
    this.name = name;
  }
}
