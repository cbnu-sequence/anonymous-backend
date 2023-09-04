package com.sequence.anonymous.college.presentation;

import com.sequence.anonymous.college.application.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {
  private final DepartmentService departmentService;
}
