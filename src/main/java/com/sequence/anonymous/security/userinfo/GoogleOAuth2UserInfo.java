package com.sequence.anonymous.security.userinfo;

import java.util.Map;

public class GoogleOAuth2UserInfo implements CustomOAuth2UserInfo {

  private final Map<String, Object> attributes;

  public GoogleOAuth2UserInfo(Map<String, Object> attributes) {
    this.attributes = attributes;
  }

  @Override
  public String getProviderId() {
    return (String) attributes.get("sub");
  }

  @Override
  public String getEmail() {
    return (String) attributes.get("email");
  }
}
