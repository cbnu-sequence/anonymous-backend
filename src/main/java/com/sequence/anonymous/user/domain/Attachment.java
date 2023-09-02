package com.sequence.anonymous.user.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Long userId;

    @Column
    @Enumerated
    private FileType fileType;

}
