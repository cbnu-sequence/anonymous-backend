package com.sequence.anonymous.friend.presentation.dto;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.friend.domain.Friend;
import com.sequence.anonymous.friend.domain.Status;
import com.sequence.anonymous.user.domain.user.User;

public record FriendResponse (Long id, User user, User friend, Status status) {

  public FriendResponse {
    Preconditions.checkArgument(user != null, "user must be provided");
    Preconditions.checkArgument(friend != null, "friend must be provided");
    Preconditions.checkArgument(status != null, "status must be provided");
  }

  public static FriendResponse fromFriend(Friend friend) {
    Preconditions.checkArgument(friend != null, "friend must be provided");

    return new FriendResponse(friend.getId(), friend.getUser(), friend.getFriend(),
        friend.getStatus());
  }
}
