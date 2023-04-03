package com.sequence.anonymous.security;

import java.util.Map;

public class GithubOAuth2UserInfo implements CustomOAuth2UserInfo {

  private final Map<String, Object> attributes;

  public GithubOAuth2UserInfo(Map<String, Object> attributes) {
    this.attributes = attributes;
  }

  @Override
  public String getProviderId() {
    return String.valueOf(attributes.get("id"));
  }

  @Override
  public String getEmail() {
    return (String) attributes.get("email");
  }
}
