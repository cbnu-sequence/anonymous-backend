package com.sequence.anonymous.friend.domain;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.user.domain.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Friend {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "friend_id")
  private User friend;

  @Enumerated(EnumType.STRING)
  private Status status;

  public Friend(User user, User friend) {
    this(null, user, friend, Status.PENDING);
  }

  protected Friend(Long id, User user, User friend, Status status) {
    Preconditions.checkArgument(user != null, "user must be provided");
    Preconditions.checkArgument(friend != null, "friend must be provided");
    Preconditions.checkArgument(status != null, "status must be provided");

    this.id = id;
    this.user = user;
    this.friend = friend;
    this.status = status;
  }

  public void updateStatus(Status status) {
    Preconditions.checkArgument(status != null, "status must be provided");

    this.status = status;
  }
}
