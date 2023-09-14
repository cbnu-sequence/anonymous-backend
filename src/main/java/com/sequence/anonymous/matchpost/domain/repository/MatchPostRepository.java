package com.sequence.anonymous.matchpost.domain.repository;

import com.sequence.anonymous.matchpost.domain.MatchPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchPostRepository extends JpaRepository<MatchPost, Long> {
}
