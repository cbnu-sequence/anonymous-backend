package com.sequence.anonymous.user.presentation;

import com.sequence.anonymous.security.CustomOAuth2User;
import com.sequence.anonymous.user.application.UserService;
import com.sequence.anonymous.user.domain.user.Gender;
import com.sequence.anonymous.user.domain.user.User;
import com.sequence.anonymous.user.dto.UserResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.web.bind.annotation.*;

@Transactional
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @GetMapping("/me")
  public ResponseEntity<UserResponse> findMyInfo(@AuthenticationPrincipal CustomOAuth2User user){
    Long currentUserId = user.getId();
    User currentUser = userService.findById(currentUserId);

    return ResponseEntity.ok(new UserResponse((User) currentUser));

  }

  @GetMapping
  public ResponseEntity<UserResponse> findUser(@RequestParam(name = "id", required = false) Long id,
                                               @RequestParam(name = "name", required = false) String name) {
    if (id != null) {
      User user = userService.findById(id);
      return ResponseEntity.ok(new UserResponse(user));
    }

    else if (name != null) {
      User user = userService.findByName(name);
      return ResponseEntity.ok(new UserResponse(user));
      }

    else {
      throw new IllegalArgumentException("Unexpected user");
    }
  }



  @PostMapping("/profiles")
  public void initializeProfile(User user, String name, Integer age, Gender gender) {
    user.initializeProfile(name, age, gender);
  }

}
