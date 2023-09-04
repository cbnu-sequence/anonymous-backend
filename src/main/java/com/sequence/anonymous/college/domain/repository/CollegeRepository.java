package com.sequence.anonymous.college.domain.repository;

import com.sequence.anonymous.college.domain.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

}