package com.sequence.anonymous.user.presentation;

import com.sequence.anonymous.user.application.UserTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-tags")
public class UserTagController {
  private final UserTagService userTagService;
}
