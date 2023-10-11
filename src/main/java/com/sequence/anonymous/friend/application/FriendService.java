package com.sequence.anonymous.friend.application;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.friend.domain.Friend;
import com.sequence.anonymous.friend.domain.repository.FriendRepository;
import com.sequence.anonymous.friend.presentation.dto.FriendResponse;
import com.sequence.anonymous.invite.domain.Invite;
import com.sequence.anonymous.invite.domain.Kind;
import com.sequence.anonymous.invite.domain.Status;
import com.sequence.anonymous.invite.domain.repository.InviteRepository;
import com.sequence.anonymous.invite.presentation.dto.InviteResponse;
import com.sequence.anonymous.user.domain.repository.UserRepository;
import com.sequence.anonymous.user.domain.user.User;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class FriendService {

  private final FriendRepository friendRepository;

  private final UserRepository userRepository;

  private final InviteRepository inviteRepository;

  @Transactional(readOnly = true)
  public List<FriendResponse> findFriendsByUserId(Long userId) {
    List<Friend> friendList = friendRepository.findByUserId(userId);

    return friendList.stream()
        .map(FriendResponse::fromFriend)
        .toList();
  }

  @Transactional(readOnly = true)
  public List<InviteResponse> findRequestsByInviterId(Long inviterId) {
    List<Invite> inviteList = inviteRepository.findByInviterIdAndStatus(inviterId, Status.WAIT);

    return inviteList.stream()
        .map(InviteResponse::fromInvite)
        .toList();
  }

  @Transactional(readOnly = true)
  public List<InviteResponse> findRequestsByInviteeId(Long inviteeId) {
    List<Invite> inviteList = inviteRepository.findByInviterIdAndStatus(inviteeId, Status.WAIT);

    return inviteList.stream()
        .map(InviteResponse::fromInvite)
        .toList();
  }

  @Transactional
  public void createNewRequest(Long inviterId, Long inviteeId) {

    Preconditions.checkArgument(inviterId != inviteeId, "inviterId and inviteeId must be different");
    Optional<Invite> optionalInvite = inviteRepository.findByInviterIdAndInviteeIdAndStatus(
        inviterId,
        inviteeId, Status.WAIT);
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

  @Transactional
  public void acceptRequest(Long id) {
    Invite invite = inviteRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("invite request not found"));
    Preconditions.checkArgument(invite.getStatus() != Status.DONE, "request has already been processed");

    friendRepository.save(new Friend(invite.getInviter(), invite.getInvitee()));
    friendRepository.save(new Friend(invite.getInvitee(), invite.getInviter()));
    invite.markAsDone();
  }

  @Transactional
  public void dismissRequest(Long id) {
    Invite invite = inviteRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("invite request not found"));
    Preconditions.checkArgument(invite.getStatus() != Status.DONE, "request has already been processed");

    invite.markAsDone();
  }

  @Transactional
  public void deleteById(Long id) {
    friendRepository.deleteById(id);
  }
}
