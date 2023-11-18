package com.sequence.anonymous.user.domain.dto;

import com.sequence.anonymous.user.domain.tag.Tag;
import lombok.Getter;

@Getter
public class TagResponse {

    private final Long id;
    private final String user;


    public TagResponse(Tag tag){
        this.id = tag.getId();
        this.user = tag.getName();
    }


}