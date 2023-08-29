package com.sequence.anonymous.user.domain.user;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.matchpost.domain.Chat;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
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
    this(null, user, chat);
  }

  private UserChat(Long id, User user, Chat chat) {
    Preconditions.checkArgument(user != null, "user must be provided.");
    Preconditions.checkArgument(chat != null, "chat must be provided.");

    this.id = id;
    this.user = user;
    this.chat = chat;
  }
}
