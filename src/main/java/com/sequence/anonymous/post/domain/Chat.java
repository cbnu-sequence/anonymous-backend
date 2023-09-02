package com.sequence.anonymous.post.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private static Long id;

    @Column
    private UUID chatIdentifier;

    public Chat(UUID chatIdentifier) {
        this.chatIdentifier = chatIdentifier;
    }
}
