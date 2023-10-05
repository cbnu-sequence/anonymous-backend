package com.sequence.anonymous.user.dto;

import com.sequence.anonymous.user.domain.user.Gender;
import com.sequence.anonymous.user.domain.user.OAuth2Provider;
import com.sequence.anonymous.user.domain.user.Role;
import com.sequence.anonymous.user.domain.user.User;
import lombok.Getter;


@Getter

public class UserResponse {

    private final Long id;
    private final String providerId;
    private final OAuth2Provider provider;
    private final String name;
    private final Integer age;
    private final Gender gender;
    private final String email;
    private final Role role;
    private final Boolean withdrawal;

    public UserResponse(User user){
        this.id = user.getId();
        this.providerId = user.getProviderId();
        this.provider = user.getProvider();
        this.name = user.getName();
        this.age = user.getAge();
        this.gender = user.getGender();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.withdrawal = user.getWithdrawal();
    }
}
