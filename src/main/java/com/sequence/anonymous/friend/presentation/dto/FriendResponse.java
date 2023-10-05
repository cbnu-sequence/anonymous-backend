package com.sequence.anonymous.friend.presentation.dto;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.friend.domain.Friend;
import com.sequence.anonymous.friend.domain.Status;
import com.sequence.anonymous.user.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FriendResponse {

  private final Long id;

  private final User user;

  private final User friend;

  private final Status status;

  @Builder
  public FriendResponse(Long id, User user, User friend, Status status) {
    Preconditions.checkArgument(user != null, "user must be provided");
    Preconditions.checkArgument(friend != null, "friend must be provided");
    Preconditions.checkArgument(status != null, "status must be provided");

    this.id = id;
    this.user = user;
    this.friend = friend;
    this.status = status;
  }

  public FriendResponse(Friend friend) {
    Preconditions.checkArgument(friend != null, "friend must be provided");

    this.id = friend.getId();
    this.user = friend.getUser();
    this.friend = friend.getFriend();
    this.status = friend.getStatus();
  }
}
