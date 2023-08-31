package com.sequence.anonymous.user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Getter
public class UserChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userChatId")
    private static Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Long userId;

    @Column(name = "chatId")
    private Long chatId;

    public UserChat(Long userId, Long chatId) {
        this.userId = userId;
        this.chatId = chatId;
    }
}
