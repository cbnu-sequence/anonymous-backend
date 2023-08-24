package com.sequence.anonymous.user.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column
    @Enumerated
    private FileType fileType;

}
