package com.sequence.anonymous.friend.presentation;

import com.sequence.anonymous.friend.application.FriendService;
import com.sequence.anonymous.friend.domain.Friend;
import com.sequence.anonymous.friend.presentation.dto.FriendResponse;
import com.sequence.anonymous.security.CustomOAuth2User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/friends")
public class FriendController {

  private final FriendService friendService;

  @GetMapping("")
  public ResponseEntity<List<FriendResponse>> findFriends(
      @AuthenticationPrincipal CustomOAuth2User user) {
    Long userId = getUserIdFromCustomOAuth2User(user);

    List<Friend> friendList = friendService.findFriendByUserId(userId);
    List<FriendResponse> friendResponseList = friendList.stream()
        .map(FriendResponse::fromFriend)
        .toList();
    return ResponseEntity.ok(friendResponseList);
  }

  @PostMapping("/{id}/invitation")
  public ResponseEntity<Void> addFriend(@PathVariable Long id,
      @AuthenticationPrincipal CustomOAuth2User user) {
    Long userId = getUserIdFromCustomOAuth2User(user);

    friendService.invite(userId, id);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/invites")
  public ResponseEntity<List<FriendResponse>> findInvites(
      @AuthenticationPrincipal CustomOAuth2User user) {
    Long userId = getUserIdFromCustomOAuth2User(user);

    List<Friend> friendList = friendService.findInviteByUserId(userId);
    List<FriendResponse> friendResponseList = friendList.stream()
        .map(FriendResponse::fromFriend)
        .toList();
    return ResponseEntity.ok(friendResponseList);
  }

  @PostMapping("/invites/{id}/accept")
  public ResponseEntity<Void> acceptInviteRequest(@PathVariable Long id) {
    friendService.acceptInvitation(id);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/invites/{id}/dismiss")
  public ResponseEntity<Void> dismissInviteRequest(@PathVariable Long id) {
    friendService.dismissInvitation(id);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteFriend(@PathVariable Long id) {
    friendService.deleteFriend(id);
    return ResponseEntity.ok().build();
  }

  private static Long getUserIdFromCustomOAuth2User(CustomOAuth2User user) {
    Object object = user.getAttribute("id");

    if (object == null) {
      throw new RuntimeException("cannot retrieve user id");
    }
    return Long.parseLong(object.toString());
  }
}
