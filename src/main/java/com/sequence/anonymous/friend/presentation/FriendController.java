package com.sequence.anonymous.friend.presentation;

import com.sequence.anonymous.friend.application.FriendService;
import com.sequence.anonymous.friend.domain.Friend;
import com.sequence.anonymous.friend.presentation.dto.FriendResponse;
import com.sequence.anonymous.invite.domain.Invite;
import com.sequence.anonymous.invite.presentation.dto.InviteResponse;
import com.sequence.anonymous.security.CustomOAuth2User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
  public ResponseEntity<List<FriendResponse>> findAllFriends(
      @AuthenticationPrincipal CustomOAuth2User user) {
    Long userId = user.getId();

    return ResponseEntity.ok(friendService.findFriendsByUserId(userId));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteFriend(@PathVariable Long id) {
    friendService.deleteById(id);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/invites/{id}/accept")
  public ResponseEntity<Void> acceptRequest(@PathVariable Long id) {
    friendService.acceptRequest(id);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/invites/{id}/dismiss")
  public ResponseEntity<Void> dismissRequest(@PathVariable Long id) {
    friendService.dismissRequest(id);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/{id}/invitation")
  public ResponseEntity<Void> createNewRequest(@PathVariable Long id,
      @AuthenticationPrincipal CustomOAuth2User user) {
    Long userId = user.getId();

    friendService.createNewRequest(userId, id);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/invites")
  public ResponseEntity<List<InviteResponse>> findAllRequests(
      @AuthenticationPrincipal CustomOAuth2User user, @RequestParam RequestType type) {
    Long userId = user.getId();
    List<InviteResponse> inviteResponseList;

    switch (type) {
      case SENT -> inviteResponseList = friendService.findRequestsByInviterId(userId);
      case RECEIVED -> inviteResponseList = friendService.findRequestsByInviteeId(userId);
      default -> throw new IllegalArgumentException("invalid request type: " + type.toString());
    }

    return ResponseEntity.ok(inviteResponseList);
  }
}
