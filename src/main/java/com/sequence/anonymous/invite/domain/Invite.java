package com.sequence.anonymous.invite.domain;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.user.domain.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
  @Column(length = 15)
  private Kind kind;

  @Enumerated(EnumType.STRING)
  @Column(length = 10)
  private Status status;

  public Invite(User inviter, User invitee, Kind kind) {
    this(inviter, invitee, kind, Status.WAIT);
  }

  private Invite(User inviter, User invitee, Kind kind, Status status) {
    Preconditions.checkArgument(inviter != null, "inviter must be provided");
    Preconditions.checkArgument(invitee != null, "invitee must be provided");
    Preconditions.checkArgument(kind != null, "kind must be provided");
    Preconditions.checkArgument(status != null, "status must be provided");
    Preconditions.checkArgument(status != Status.DONE, "initial value of status cannot be DONE");

    this.inviter = inviter;
    this.invitee = invitee;
    this.kind = kind;
    this.status = status;
  }

  public void markAsDone() {
    this.status = Status.DONE;
  }
}
