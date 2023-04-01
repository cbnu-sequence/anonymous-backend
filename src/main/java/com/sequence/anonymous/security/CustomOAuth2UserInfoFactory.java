package com.sequence.anonymous.security;

import com.sequence.anonymous.user.domain.OAuth2Provider;
import java.util.Map;

public class CustomOAuth2UserInfoFactory {

  public static CustomOAuth2UserInfo create(OAuth2Provider oAuth2Provider,
    Map<String, Object> attributes) {
    return switch (oAuth2Provider) {
      case GITHUB -> new GithubOAuth2UserInfo(attributes);
      default -> throw new IllegalArgumentException();
    };
  }
}
