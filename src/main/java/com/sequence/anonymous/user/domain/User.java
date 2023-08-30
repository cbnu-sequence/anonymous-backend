package com.sequence.anonymous.user.domain;

import com.google.common.base.Preconditions;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {

  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "college_id")
  private College college;

  @ManyToOne
  @JoinColumn(name = "department_id")
  private Department department;

  @OneToMany
  private List<Invite> inviter = new ArrayList<>();

  @OneToMany
  private List<Invite> invitee = new ArrayList<>();

  @OneToMany
  private List<Attachment> attachment = new ArrayList<>();

  @OneToMany
  private List<UserChat> userChat = new ArrayList<>();

  private String name;

  private int age;

  @Enumerated(EnumType.STRING)
  private Gender gender;

  private boolean withdrawl;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private String providerId;

  @Column(length = 10)
  @Enumerated(EnumType.STRING)
  private OAuth2Provider provider;

  @Column(length = 40)
  private String email;

  @Column(length = 15)
  @Enumerated(EnumType.STRING)
  private Role role;

  @OneToMany
  private List<UserMatchPost> usermatch_post= new ArrayList<>();

  @OneToMany
  private List<UserTag> usertag = new ArrayList<>();

  protected User() {
  }

  public User(String providerId, OAuth2Provider provider, String email) {
    this(null, providerId, provider, email, Role.ROLE_USER);
  }

  private User(Long id, String providerId, OAuth2Provider provider, String email, Role role) {
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
