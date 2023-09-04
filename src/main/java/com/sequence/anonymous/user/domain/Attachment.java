package com.sequence.anonymous.user.domain;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.user.domain.user.User;
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

    private String name;

    @Enumerated(EnumType.STRING)
    private FileType type;

    protected Attachment(){

    }

    public Attachment(User user, String name, FileType type) {
        this.user = user;
        this.name = name;
        this.type = type;
    }

    private Attachment(Long id, User user, String name, FileType type){
        Preconditions.checkArgument(user != null, "user must be provided");
        Preconditions.checkArgument(type != null, "filetype must be provided");

        this.id = id;
        this.user = user;
        this.name = name;
        this.type = type;

    }


}
