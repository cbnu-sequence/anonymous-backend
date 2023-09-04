package com.sequence.anonymous.user.domain.chat;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity @Getter
public class Chat {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Long id;

    @OneToMany
    private List<UserChat> userChat = new ArrayList<>();

    @Column
    private UUID chatIdentifier;

    protected Chat(){

    }
    public Chat(UUID chatIdentifier) {
        this.chatIdentifier = chatIdentifier;
    }

    private Chat(Long id, UUID chatIdentifier){
        this.id = id;
        this.chatIdentifier = chatIdentifier;
    }

}
