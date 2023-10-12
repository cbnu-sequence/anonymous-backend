package com.sequence.anonymous.user.application;

import com.sequence.anonymous.security.CustomOAuth2User;
import com.sequence.anonymous.user.domain.repository.UserRepository;
import com.sequence.anonymous.user.domain.user.Gender;
import com.sequence.anonymous.user.domain.user.User;
import com.sequence.anonymous.user.dto.InitializeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;


  public User findById(Long userId) {
    return userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("not found : " + userId));
  }

  public User findByName(String userName) {
    return userRepository.findByName(userName)
            .orElseThrow(() -> new IllegalArgumentException("not found : " + userName));
  }

  public void initializeProfile(Long userId, InitializeRequest initializeRequest){


    User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("not found : " + userId));
    user.initializeProfile(initializeRequest.getName(), initializeRequest.getAge(), initializeRequest.getGender());
  }


}
