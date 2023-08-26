package com.sequence.anonymous.invite.domain;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.user.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;

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

  @Column(length = 10)
  @Enumerated(EnumType.STRING)
  private Status status;


  @Column(length = 15)
  @Enumerated(EnumType.STRING)
  private Kind kind;

  protected Invite() {
  }

  public Invite(User inviter, User invitee, Kind kind) {
    this(inviter, invitee, kind, Status.WAIT);
  }

  private Invite(User inviter, User invitee, Kind kind, Status status) {
    Preconditions.checkArgument(inviter != null, "inviter must be provided");
    Preconditions.checkArgument(invitee != null, "invitee must be provided");
    Preconditions.checkArgument(kind != null, "kind must be provided");
    Preconditions.checkArgument(status != null, "status must be provided");

    this.inviter = inviter;
    this.invitee = invitee;
    this.kind = kind;
    this.status = status;
  }

  public void update(Status status) {
    this.status = ObjectUtils.defaultIfNull(status, this.status);
  }
}
