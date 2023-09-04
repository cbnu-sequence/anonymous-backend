package com.sequence.anonymous.user.domain;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.chat.domain.Chat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class UserChat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "chat_id")
  private Chat chat;

  protected UserChat() {
  }

  public UserChat(User user, Chat chat) {
    Preconditions.checkArgument(user != null, "user must be provided");
    Preconditions.checkArgument(chat != null, "chat must be provided");

    this.id = null;
    this.user = user;
    this.chat = chat;
  }
}
