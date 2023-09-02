package com.sequence.anonymous.user.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class UserChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userChat_id")
    private static Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Long userId;

    @OneToMany
    @JoinColumn(name = "chat_id")
    private Long chatId;

    public UserChat(Long userId, Long chatId) {
        this.userId = userId;
        this.chatId = chatId;
    }
}
