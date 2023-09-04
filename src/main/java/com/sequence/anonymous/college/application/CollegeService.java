package com.sequence.anonymous.college.application;

import com.sequence.anonymous.college.domain.repository.CollegeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CollegeService {
  private final CollegeRepository collegeRepository;
}
