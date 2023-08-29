package com.sequence.anonymous.matchpost.domain.repository;

import com.sequence.anonymous.matchpost.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
}
