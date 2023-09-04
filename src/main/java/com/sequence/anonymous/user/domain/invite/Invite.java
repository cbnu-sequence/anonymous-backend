package com.sequence.anonymous.user.domain.invite;

import com.sequence.anonymous.user.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Invite {

    @Id
    @Column(name = "invite_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Column(name = "inviter")
    private User inviter;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Column(name = "invitee")
    private User invitee;

    @Enumerated(EnumType.STRING)
    private InviteStatus status;

    @Enumerated(EnumType.STRING)
    private InviteKind kind;
}
