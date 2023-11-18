package com.sequence.anonymous.user.domain.dto;

import com.sequence.anonymous.user.domain.College;
import com.sequence.anonymous.user.domain.tag.Tag;
import lombok.Getter;

@Getter
public class CollegeResponse {

    private final Long id;
    private final String collegeName;


    public CollegeResponse(College college){

        this.id = college.getId();
        this.collegeName = college.getName();

    }


}
