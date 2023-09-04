package com.sequence.anonymous.user.domain.repository;

import com.sequence.anonymous.user.domain.UserMatchPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMatchPostRepository extends JpaRepository<UserMatchPost, Long> {

}
