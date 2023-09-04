package com.sequence.anonymous.user.domain.repository;

import com.sequence.anonymous.user.domain.UserChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserChatRepository extends JpaRepository<UserChat, Long> {

}
