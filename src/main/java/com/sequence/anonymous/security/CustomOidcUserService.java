package com.sequence.anonymous.security;

import com.sequence.anonymous.user.domain.OAuth2Provider;
import com.sequence.anonymous.user.domain.User;
import com.sequence.anonymous.user.domain.repository.UserRepository;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomOidcUserService extends OidcUserService {

  private final UserRepository userRepository;

  @Override
  public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
    OidcUser oidcUser = super.loadUser(userRequest);
    OAuth2Provider oAuth2Provider = OAuth2Provider.getProvider(userRequest);
    User user = processUser(oAuth2Provider, oidcUser.getAttributes());
    return new CustomOidcUser(oidcUser, user.getId(), user.getRole());
  }

  private User processUser(OAuth2Provider provider, Map<String, Object> attributes) {
    CustomOAuth2UserInfo userInfo = CustomOAuth2UserInfoFactory.create(provider, attributes);
    String email = userInfo.getEmail();
    String providerId = userInfo.getProviderId();
    return userRepository.findByEmailAndProviderId(email, providerId)
      .orElseGet(() -> {
        User user = new User(providerId, provider, email);
        return userRepository.save(user);
      });
  }
}
