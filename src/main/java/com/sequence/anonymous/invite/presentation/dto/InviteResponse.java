package com.sequence.anonymous.invite.presentation.dto;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.invite.domain.Invite;
import com.sequence.anonymous.invite.domain.Kind;
import com.sequence.anonymous.invite.domain.Status;
import com.sequence.anonymous.user.domain.user.User;

public record InviteResponse (Long id, User inviter, User invitee, Kind kind, Status status){

  public InviteResponse {
    Preconditions.checkArgument(id != null, "id must be provided");
    Preconditions.checkArgument(inviter!=null, "inviter must be provided");
    Preconditions.checkArgument(invitee!=null, "invitee must be provided");
    Preconditions.checkArgument(kind!=null, "kind must be provided");
    Preconditions.checkArgument(status != null, "status must be provided");
  }

  public static InviteResponse fromInvite(Invite invite) {
    Preconditions.checkArgument(invite != null);

    return new InviteResponse(invite.getId(), invite.getInviter(), invite.getInvitee(), invite.getKind(),
        invite.getStatus());
  }
}
