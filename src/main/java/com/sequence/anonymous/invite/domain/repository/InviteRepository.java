package com.sequence.anonymous.invite.domain.repository;

import com.sequence.anonymous.invite.domain.Invite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InviteRepository extends JpaRepository<Invite, Long> {
}
