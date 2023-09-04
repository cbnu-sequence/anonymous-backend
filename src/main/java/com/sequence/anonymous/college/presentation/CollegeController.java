package com.sequence.anonymous.college.presentation;

import com.sequence.anonymous.college.application.CollegeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/colleges")
public class CollegeController {
  private final CollegeService collegeService;
}
