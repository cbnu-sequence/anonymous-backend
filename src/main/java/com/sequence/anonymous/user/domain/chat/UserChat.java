package com.sequence.anonymous.user.domain.chat;

import com.sequence.anonymous.user.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class UserChat {

    @Id
    @Column(name = "userchat_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

}
