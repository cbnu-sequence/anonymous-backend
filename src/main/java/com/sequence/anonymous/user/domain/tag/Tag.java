package com.sequence.anonymous.user.domain.tag;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@Entity
public class Tag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, insertable = false, updatable = false, length = 10)
  @NotNull
  private String name;

  protected Tag() {
  }
}
