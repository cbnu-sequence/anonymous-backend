package com.sequence.anonymous.user.presentation;

import com.sequence.anonymous.user.application.UserService;
import com.sequence.anonymous.user.domain.user.Gender;
import com.sequence.anonymous.user.domain.user.User;
import com.sequence.anonymous.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @GetMapping("/me")
  public ResponseEntity<UserResponse> findMyInfo(){
    List<User> user = userService.findMyInfo();
    return ResponseEntity.ok()
            .body(new UserResponse((User) user));
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponse> findUserById(@PathVariable Long id){
    User user = userService.findById(id);
    return ResponseEntity.ok()
            .body(new UserResponse(user));
  }
  @GetMapping("/{name}")
  public ResponseEntity<UserResponse> findUserByName(@PathVariable String name){
    User user = userService.findByName(name);
    return ResponseEntity.ok()
            .body(new UserResponse(user));
  }

  @PostMapping("/profiles")
  public ResponseEntity<List<User>> initializeProfile(String name, Integer age, Gender gender) {
    User user = userService.initializeProfile(name, age, gender);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body((List<User>) user);
  }

}
