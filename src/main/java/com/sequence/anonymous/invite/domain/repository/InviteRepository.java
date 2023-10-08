package com.sequence.anonymous.invite.domain.repository;

import com.sequence.anonymous.invite.domain.Invite;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InviteRepository extends JpaRepository<Invite, Long> {

  List<Invite> findByInviterId(Long inviterId);

  List<Invite> findByInviteeId(Long inviteeId);

  Optional<Invite> findByInviterIdAndInviteeId(Long inviterId, Long inviteeId);

}
