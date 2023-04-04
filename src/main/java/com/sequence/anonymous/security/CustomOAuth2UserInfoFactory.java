package com.sequence.anonymous.security;

import com.sequence.anonymous.security.userinfo.CustomOAuth2UserInfo;
import com.sequence.anonymous.security.userinfo.GithubOAuth2UserInfo;
import com.sequence.anonymous.security.userinfo.GoogleOAuth2UserInfo;
import com.sequence.anonymous.security.userinfo.KakaoOAuth2UserInfo;
import com.sequence.anonymous.user.domain.OAuth2Provider;
import java.util.Map;

public class CustomOAuth2UserInfoFactory {

  public static CustomOAuth2UserInfo create(OAuth2Provider oAuth2Provider,
    Map<String, Object> attributes) {
    return switch (oAuth2Provider) {
      case GITHUB -> new GithubOAuth2UserInfo(attributes);
      case GOOGLE -> new GoogleOAuth2UserInfo(attributes);
      case KAKAO -> new KakaoOAuth2UserInfo(attributes);
    };
  }
}
