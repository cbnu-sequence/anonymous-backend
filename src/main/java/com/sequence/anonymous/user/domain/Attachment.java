package com.sequence.anonymous.user.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Getter @Entity
public class Attachment {

    @Id
    @Column(name = "attachment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    String name;

    @Enumerated(EnumType.STRING)
    private FileType type;

}
