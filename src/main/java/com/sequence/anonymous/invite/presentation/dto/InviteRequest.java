package com.sequence.anonymous.invite.presentation.dto;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.invite.domain.Kind;
import com.sequence.anonymous.invite.domain.Status;

public record InviteRequest (Long inviterId, Long inviteeId, Kind kind, Status status){

  public InviteRequest {
    Preconditions.checkArgument(inviterId!=null, "inviterId must be provided");
    Preconditions.checkArgument(inviteeId!=null, "inviteeId must be provided");
    Preconditions.checkArgument(kind!=null, "kind must be provided");
    Preconditions.checkArgument(status != null, "status must be provided");
  }
}
