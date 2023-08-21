package com.sequence.anonymous.invite.domain;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.user.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Invite {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "inviter_id")
  private User inviter;

  @ManyToOne
  @JoinColumn(name = "invitee_id")
  private User invitee;

  @Enumerated(EnumType.STRING)
  private InviteStatus status;

  @Enumerated(EnumType.STRING)
  private InviteKind kind;

  protected Invite() {
  }

  public Invite(User inviter, User invitee, InviteKind kind) {
    this(inviter, invitee, kind, InviteStatus.WAIT);
  }

  private Invite(User inviter, User invitee, InviteKind kind, InviteStatus status) {
    Preconditions.checkArgument(inviter != null, "inviter must be provided");
    Preconditions.checkArgument(invitee != null, "invitee must be provided");
    Preconditions.checkArgument(kind != null, "kind must be provided");

    this.inviter = inviter;
    this.invitee = invitee;
    this.kind = kind;
    this.status = status;
  }

  public void updateStatus(InviteStatus status) {
    Preconditions.checkArgument(status != null, "status must be provided");

    this.status = status;
  }
}
