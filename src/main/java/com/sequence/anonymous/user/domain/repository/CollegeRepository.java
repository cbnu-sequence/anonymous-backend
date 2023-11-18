package com.sequence.anonymous.user.domain.repository;

import com.sequence.anonymous.user.domain.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

}