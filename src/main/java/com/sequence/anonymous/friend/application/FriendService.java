package com.sequence.anonymous.friend.application;

import com.sequence.anonymous.friend.domain.Friend;
import com.sequence.anonymous.friend.domain.Status;
import com.sequence.anonymous.friend.domain.repository.FriendRepository;
import com.sequence.anonymous.user.domain.repository.UserRepository;
import com.sequence.anonymous.user.domain.user.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class FriendService {

  private final FriendRepository friendRepository;

  private final UserRepository userRepository;

  public List<Friend> findFriendByUserId(Long userId) {
    return friendRepository.findByUserIdOrFriendId(userId);
  }

  public void invite(Long userId, Long friendId) {

    if (friendRepository.findByUserIdAndFriendId(userId, friendId).isPresent()) {
      throw new RuntimeException("Duplicate Request");
    }

    User user = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("user not found"));
    User friend = userRepository.findById(friendId)
        .orElseThrow(() -> new NotFoundException("friend not found"));
    friendRepository.save(new Friend(user, friend));
  }

  public List<Friend> findInviteByUserId(Long userId) {
    return friendRepository.findByUserIdOrFriendIdAndStatus(userId, Status.PENDING);
  }

  public void acceptInvitation(Long id) {
    Friend friend = friendRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("friend not found"));
    friend.updateStatus(Status.FRIEND);
  }

  public void dismissInvitation(Long id) {
    friendRepository.deleteById(id);
  }

  public void deleteFriend(Long id) {
    friendRepository.deleteById(id);
  }
}
