package com.sequence.anonymous.friend.presentation;

import com.sequence.anonymous.friend.application.FriendService;
import com.sequence.anonymous.friend.domain.Friend;
import com.sequence.anonymous.friend.presentation.dto.FriendResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/friends")
public class FriendController {

  private final FriendService friendService;

  @GetMapping("")
  public ResponseEntity<List<FriendResponse>> findFriends() {
    Long userId = 1L; //spring security를 통해 인증 정보 찾을 예정

    List<Friend> friendList = friendService.findFriendByUserId(userId);
    List<FriendResponse> friendResponseList = friendList.stream()
        .map(FriendResponse::new)
        .toList();
    return ResponseEntity.status(HttpStatus.OK).body(friendResponseList);
  }

  @PostMapping("/{id}/invitation")
  public ResponseEntity<Void> addFriend(@PathVariable Long id) {
    Long userId = 1L; //spring security를 통해 인증 정보 찾을 예정

    friendService.invite(userId, id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @GetMapping("/invites")
  public ResponseEntity<List<FriendResponse>> findInvites() {
    Long id = 1L; //spring security를 통해 인증 정보 찾을 예정

    List<Friend> friendList = friendService.findInviteByUserId(id);
    List<FriendResponse> friendResponseList = friendList.stream()
        .map(FriendResponse::new)
        .toList();
    return ResponseEntity.status(HttpStatus.OK).body(friendResponseList);
  }

  @PostMapping("/invites/{id}/accept")
  public ResponseEntity<Void> acceptInviteRequest(@PathVariable Long id) {
    friendService.acceptInvitation(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @PostMapping("/invites/{id}/dismiss")
  public ResponseEntity<Void> dismissInviteRequest(@PathVariable Long id) {
    friendService.dismissInvitation(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteFriend(@PathVariable Long id) {
    friendService.deleteFriend(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
