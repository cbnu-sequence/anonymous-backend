package com.sequence.anonymous.user.domain.repository;

import com.sequence.anonymous.user.domain.UserTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTagRepository extends JpaRepository<UserTag, Long> {

}
