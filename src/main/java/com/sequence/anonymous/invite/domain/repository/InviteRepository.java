package com.sequence.anonymous.invite.domain.repository;

import com.sequence.anonymous.invite.domain.Invite;
import com.sequence.anonymous.invite.domain.Status;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InviteRepository extends JpaRepository<Invite, Long> {

  List<Invite> findByInviterIdAndStatus(Long inviterId, Status status);

  List<Invite> findByInviteeIdAndStatus(Long inviteeId, Status status);

  Optional<Invite> findByInviterIdAndInviteeIdAndStatus(Long inviterId, Long inviteeId, Status status);

}
