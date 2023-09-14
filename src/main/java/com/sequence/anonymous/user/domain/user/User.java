package com.sequence.anonymous.user.domain.user;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class User extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String providerId;

  @Column(length = 10)
  @Enumerated(EnumType.STRING)
  private OAuth2Provider provider;

  @Column(length = 40, unique = true)
  private String email;

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

  protected User() {
  }

  public User(String providerId, OAuth2Provider provider, String email) {
    this(null, providerId, provider, email, null, null, null, Role.ROLE_USER, false);
  }

  private User(Long id, String providerId, OAuth2Provider provider, String email, String name, Integer age, Gender gender, Role role, Boolean withdrawal) {
    Preconditions.checkArgument(providerId != null, "providerId must be provided.");
    Preconditions.checkArgument(provider != null, "provider must be provided.");
    Preconditions.checkArgument(email != null, "email must be provided.");
    Preconditions.checkArgument(role != null, "role must be provided.");
    Preconditions.checkArgument(withdrawal != null, "withdrawal must be provided.");

    this.id = id;
    this.providerId = providerId;
    this.provider = provider;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.email = email;
    this.role = role;
    this.withdrawal = withdrawal;
  }

  public void initializeProfile(String name, Integer age, Gender gender) {
    Preconditions.checkArgument(name != null, "name must be provided.");
    Preconditions.checkArgument(age != null, "age must be provided.");
    Preconditions.checkArgument(gender != null, "gender must be provided.");

    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  public boolean isProfileInitialized() {
    return (name != null) && (age != null) && (gender != null);
  }
}
