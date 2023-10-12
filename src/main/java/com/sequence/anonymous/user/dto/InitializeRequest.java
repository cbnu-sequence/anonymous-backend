package com.sequence.anonymous.user.dto;

import com.sequence.anonymous.user.domain.user.Gender;
import com.sequence.anonymous.user.domain.user.User;
import lombok.Getter;

@Getter
public class InitializeRequest {
    private String name;
    private Integer age;
    private Gender gender;


}
