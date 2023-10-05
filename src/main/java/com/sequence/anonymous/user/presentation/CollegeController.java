package com.sequence.anonymous.user.presentation;


import com.sequence.anonymous.user.application.CollegeService;
import com.sequence.anonymous.user.domain.College;
import com.sequence.anonymous.user.domain.tag.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

    private final CollegeService collegeService;

    @GetMapping("/")
    public ResponseEntity<List<College>> findAll(){

        List<College> college = collegeService.printAll();
        return ResponseEntity.status(HttpStatus.CREATED).body((List<College>) college);
    }

}
