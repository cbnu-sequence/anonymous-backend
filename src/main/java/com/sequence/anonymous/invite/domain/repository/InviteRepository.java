package com.sequence.anonymous.invite.domain.repository;

import com.sequence.anonymous.invite.domain.Invite;
import com.sequence.anonymous.invite.domain.Status;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InviteRepository extends JpaRepository<Invite, Long> {

  @Query("SELECT i FROM Invite AS i JOIN FETCH i.invitee JOIN FETCH i.inviter WHERE i.inviter.id = :inviterId AND i.status = :status")
  List<Invite> findByInviterIdAndStatusWithInviterAndInvitee(Long inviterId, Status status);

  @Query("SELECT i FROM Invite AS i JOIN FETCH i.invitee JOIN FETCH i.inviter WHERE i.invitee.id = :inviteeId AND i.status = :status")
  List<Invite> findByInviteeIdAndStatusWithInviterAndInvitee(Long inviteeId, Status status);

  Optional<Invite> findByInviterIdAndInviteeIdAndStatus(Long inviterId, Long inviteeId, Status status);

}
