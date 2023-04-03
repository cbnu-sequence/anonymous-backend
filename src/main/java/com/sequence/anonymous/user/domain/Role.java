package com.sequence.anonymous.user.domain;

public enum Role {
  ROLE_USER("USER"),
  ROLE_ADMIN("ADMIN");

  private final String role;

  Role(String role) {
    this.role = role;
  }

  public String role() {
    return role;
  }
}
