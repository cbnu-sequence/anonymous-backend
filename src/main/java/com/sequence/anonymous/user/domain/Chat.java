package com.sequence.anonymous.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity @Getter
public class Chat {

    @Id
    @Column(name = "chat_id")
    private Long id;

    @OneToMany
    private List<UserChat> userChat = new ArrayList<>();

    // UUID ..?

}
