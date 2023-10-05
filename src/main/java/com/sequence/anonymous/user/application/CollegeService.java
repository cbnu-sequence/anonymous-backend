package com.sequence.anonymous.user.application;

import com.sequence.anonymous.user.domain.College;
import com.sequence.anonymous.user.domain.repository.CollegeRepository;
import com.sequence.anonymous.user.domain.repository.TagRepository;
import com.sequence.anonymous.user.domain.tag.Tag;

import java.util.List;

public class CollegeService {

    private CollegeRepository collegeRepository;


    public List<College> printAll(){
        return collegeRepository.findAll();
    }
}
