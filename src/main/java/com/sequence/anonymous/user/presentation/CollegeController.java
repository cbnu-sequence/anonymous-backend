package com.sequence.anonymous.user.presentation;


import com.sequence.anonymous.user.application.CollegeService;
import com.sequence.anonymous.user.domain.College;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/colleges")
public class CollegeController {

    private final CollegeService collegeService;

    @GetMapping("")
    public ResponseEntity<List<College>> findAll(){

        List<College> college = collegeService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body((List<College>) college);
    }
}
