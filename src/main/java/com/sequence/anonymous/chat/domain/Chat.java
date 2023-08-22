package com.sequence.anonymous.chat.domain;

import com.google.common.base.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Getter;

@Entity
@Getter
public class Chat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private UUID chatIdentifier;

  protected Chat() {
  }

  public Chat(UUID chatIdentifier) {
    Preconditions.checkArgument(chatIdentifier != null, "chatIdentifier must be provided");

    this.id = null;
    this.chatIdentifier = chatIdentifier;
  }
}
