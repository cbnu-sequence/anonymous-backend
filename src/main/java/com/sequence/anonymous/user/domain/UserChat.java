package com.sequence.anonymous.user.domain;

import jakarta.persistence.*;

@Entity
public class UserChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userChatId")
    private static Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "chatId")
    private Long chatId;

}
