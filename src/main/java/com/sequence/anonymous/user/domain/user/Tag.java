package com.sequence.anonymous.user.domain.user;

import com.sequence.anonymous.user.domain.user.UserTag;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Tag {

    @Id
    @Column(name = "tag_id")
    private Long id;

    private String name;

    @OneToMany
    private List<UserTag> usertag = new ArrayList<>();

    protected Tag(){

    }

    public Tag(String name) {
        this.name = name;
    }

    private Tag(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
