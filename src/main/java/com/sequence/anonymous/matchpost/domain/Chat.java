package com.sequence.anonymous.matchpost.domain;

import com.google.common.base.Preconditions;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity
public class Chat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private UUID identifier;

  protected Chat() {
  }

  public Chat(UUID identifier) {
    this(null, identifier);
  }

  private Chat(Long id, UUID identifier) {
    Preconditions.checkArgument(identifier != null, "identifier must be provided.");

    this.id = id;
    this.identifier = identifier;
  }
}
