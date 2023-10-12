package com.sequence.anonymous.friend.domain.repository;

import com.sequence.anonymous.friend.domain.Friend;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {

  @Query("SELECT f from Friend AS f JOIN FETCH f.friend JOIN FETCH f.user WHERE f.user.id= :userId")
  List<Friend> findByUserIdWithUserAndFriend(Long userId);

  Optional<Friend> findByUserIdAndFriendId(Long userId, Long friendId);
}
