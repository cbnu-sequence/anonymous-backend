package com.sequence.anonymous.user.domain;

import com.google.common.base.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "userId")
  private static Long id;

  private String providerId;

  @Column(length = 10)
  @Enumerated(EnumType.STRING)
  private OAuth2Provider provider;

  @Column(length = 40)
  private String email;

  @Column
  private Long college;

  @Column
  private Long department;

  @Column(length = 20)
  private String name;

  private Integer age;

  @Column(length = 10)
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Column(length = 15)
  @Enumerated(EnumType.STRING)
  private Role role;

  private Boolean withdrawal;

  private Boolean profileInitialized;

  protected User() {
  }

  public User(String providerId, OAuth2Provider provider, String email) {
    this(null, providerId, provider, email, null, null, null, Role.ROLE_USER, false, false);
  }
  private User(Long id, String providerId, OAuth2Provider provider, String email, String name, Integer age, Gender gender, Role role, Boolean withdrawal, Boolean profileInitialized) {
    Preconditions.checkArgument(providerId != null, "providerId must be provided.");
    Preconditions.checkArgument(provider != null, "provider must be provided.");
    Preconditions.checkArgument(email != null, "email must be provided.");
    Preconditions.checkArgument(role != null, "role must be provided.");
    Preconditions.checkArgument(withdrawal != null, "withdrawal must be provided.");
    Preconditions.checkArgument(profileInitialized != null, "initialized must be provided.");

    this.id = id;
    this.providerId = providerId;
    this.provider = provider;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.email = email;
    this.role = role;
    this.withdrawal = withdrawal;
    this.profileInitialized = profileInitialized;
  }

  public void initializeProfile(String name, Integer age, Gender gender) {
    Preconditions.checkArgument(name != null, "name must be provided.");
    Preconditions.checkArgument(age != null, "age must be provided.");
    Preconditions.checkArgument(gender != null, "gender must be provided.");

    this.name = name;
    this.age = age;
    this.gender = gender;

    this.profileInitialized = true;
  }
}