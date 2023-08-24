package com.sequence.anonymous.invite.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Invite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inviteId")
    private static Long id;

    @Column(name = "inviterId")
    private Long inviter;

    @Column(name = "inviteeId")
    private Long invitee;

    @Column
    private InviteStatus status;

    @Column
    private InviteKind kind;
}
