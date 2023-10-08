package com.sequence.anonymous.friend.domain.repository;

import com.sequence.anonymous.friend.domain.Friend;
import com.sequence.anonymous.user.domain.user.User;
import jakarta.persistence.criteria.From;
import java.util.Formattable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {

  List<Friend> findByUserId(Long userId);

  Optional<Friend> findByUserIdAndFriendId(Long userId, Long friendId);
}
