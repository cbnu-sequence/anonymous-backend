package com.sequence.anonymous.invite.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Invite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invite_id")
    private static Long id;

    @OneToOne
    @JoinColumn(name = "inviter_id")
    private Long inviter;

    @OneToMany
    @JoinColumn(name = "invitee_id")
    private Long invitee;

    @Column
    private InviteStatus status;

    @Column
    private InviteKind kind;
}
