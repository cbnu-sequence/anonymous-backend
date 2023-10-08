package com.sequence.anonymous.friend.application;

import com.sequence.anonymous.friend.domain.Friend;
import com.sequence.anonymous.friend.domain.repository.FriendRepository;
import com.sequence.anonymous.invite.domain.Invite;
import com.sequence.anonymous.invite.domain.Kind;
import com.sequence.anonymous.invite.domain.repository.InviteRepository;
import com.sequence.anonymous.user.domain.repository.UserRepository;
import com.sequence.anonymous.user.domain.user.User;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class FriendService {

  private final FriendRepository friendRepository;

  private final UserRepository userRepository;

  private final InviteRepository inviteRepository;

  public List<Friend> findFriendsByUserId(Long userId) {
    return friendRepository.findByUserId(userId);
  }

  public List<Invite> findRequestsByInviterId(Long inviterId) {
    return inviteRepository.findByInviterId(inviterId);
  }

  public List<Invite> findRequestsByInviteeId(Long inviteeId) {
    return inviteRepository.findByInviteeId(inviteeId);
  }

  public void createNewRequest(Long inviterId, Long inviteeId) {
    Optional<Invite> optionalInvite = inviteRepository.findByInviterIdAndInviteeId(inviterId,
        inviteeId);
    optionalInvite.ifPresent(invite -> {
      throw new RuntimeException("duplicate request");
    });

    Optional<Friend> optionalFriend = friendRepository.findByUserIdAndFriendId(inviterId,
        inviteeId);
    optionalFriend.ifPresent(friend -> {
      throw new RuntimeException("already a friend");
    });

    User inviter = userRepository.findById(inviterId)
        .orElseThrow(() -> new NotFoundException("inviter not found"));
    User invitee = userRepository.findById(inviteeId)
        .orElseThrow(() -> new NotFoundException("invitee not found"));

    inviteRepository.save(new Invite(inviter, invitee, Kind.FRIEND));
  }

  public void acceptRequest(Long id) {
    Invite invite = inviteRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("invite request not found"));

    friendRepository.save(new Friend(invite.getInviter(), invite.getInvitee()));
    friendRepository.save(new Friend(invite.getInvitee(), invite.getInviter()));
    invite.markAsDone();
  }

  public void dismissRequest(Long id) {
    Invite invite = inviteRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("invite request not found"));

    invite.markAsDone();
  }

  public void deleteById(Long id) {
    friendRepository.deleteById(id);
  }
}
