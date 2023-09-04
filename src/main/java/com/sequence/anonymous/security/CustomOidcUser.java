package com.sequence.anonymous.security;

import com.sequence.anonymous.user.domain.user.Role;
import java.util.Map;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

public class CustomOidcUser extends CustomOAuth2User implements OidcUser {

  private final OidcUser oidcUser;

  public CustomOidcUser(OidcUser oAuth2User, Long id, Role role) {
    super(oAuth2User, id, role);
    this.oidcUser = oAuth2User;
  }

  @Override
  public Map<String, Object> getClaims() {
    return this.getAttributes();
  }

  @Override
  public OidcUserInfo getUserInfo() {
    return oidcUser.getUserInfo();
  }

  @Override
  public OidcIdToken getIdToken() {
    return oidcUser.getIdToken();
  }
}
