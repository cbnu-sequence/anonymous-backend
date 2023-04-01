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
  private Long id;

  private Long providerId;

  @Column(length = 10)
  @Enumerated(EnumType.STRING)
  private OAuth2Provider provider;

  @Column(unique = true)
  private String email;

  @Column(length = 15)
  @Enumerated(EnumType.STRING)
  private Role role;

  protected User() {
  }

  public User(Long providerId, OAuth2Provider provider, String email) {
    this(null, providerId, provider, email, Role.ROLE_USER);
  }

  private User(Long id, Long providerId, OAuth2Provider provider, String email, Role role) {
    Preconditions.checkArgument(providerId != null, "providerId must be provided.");
    Preconditions.checkArgument(provider != null, "provider must be provided.");
    Preconditions.checkArgument(email != null, "email must be provided.");
    Preconditions.checkArgument(role != null, "role must be provided.");

    this.id = id;
    this.providerId = providerId;
    this.provider = provider;
    this.email = email;
    this.role = role;
  }
}
