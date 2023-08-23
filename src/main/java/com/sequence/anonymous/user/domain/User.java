package com.sequence.anonymous.user.domain;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.college.domain.College;
import com.sequence.anonymous.college.domain.Department;
import com.sequence.anonymous.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import lombok.Getter;

@Entity
@Getter
public class User extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String providerId;

  @Column(length = 10)
  @Enumerated(EnumType.STRING)
  private OAuth2Provider provider;

  @Column(length = 10, nullable = false)
  private String name;

  @Column(nullable = false)
  private int age;

  @Enumerated(EnumType.STRING)
  @Column(length = 10, nullable = false)
  private Gender gender;

  @ManyToOne
  @JoinColumn(name = "college_id")
  private College college;

  @ManyToOne
  @JoinColumn(name = "department_id")
  private Department department;

  @Column(length = 40, unique = true)
  private String email;

  @Column(length = 15)
  @Enumerated(EnumType.STRING)
  private Role role;

  private boolean withdrawal;

  protected User() {
  }

  public User(String providerId, OAuth2Provider provider, String email) {
    this(null, providerId, provider, email, Role.ROLE_USER, false);
  }

  private User(Long id, String providerId, OAuth2Provider provider, String email, Role role,
      Boolean withdrawal) {
    Preconditions.checkArgument(providerId != null, "providerId must be provided.");
    Preconditions.checkArgument(provider != null, "provider must be provided.");
    Preconditions.checkArgument(email != null, "email must be provided.");
    Preconditions.checkArgument(role != null, "role must be provided.");
    Preconditions.checkArgument(withdrawal, "initial value of withdrawal field must be false.");

    this.id = id;
    this.providerId = providerId;
    this.provider = provider;
    this.email = email;
    this.role = role;
    this.withdrawal = withdrawal;
  }

  public void initializeProfile(String name, int age, Gender gender, College college, Department department) {
    Preconditions.checkArgument(name != null, "name must be provided.");
    Preconditions.checkArgument(gender != null, "gender must be provided.");
    Preconditions.checkArgument(college != null, "college must be provided.");
    Preconditions.checkArgument(department != null, "department must be provided.");
    Preconditions.checkArgument(age >= 20, "age must be at least 20");

    this.name = name;
    this.age = age;
    this.gender = gender;
    this.college = college;
    this.department = department;
  }
}
