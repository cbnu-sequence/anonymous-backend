package com.sequence.anonymous.user.application;

import com.sequence.anonymous.user.domain.College;
import com.sequence.anonymous.user.domain.repository.CollegeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CollegeService {

    private final CollegeRepository collegeRepository;


    public List<College> findAll() {
        return collegeRepository.findAll();
    }
}
