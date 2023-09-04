package com.sequence.anonymous.user.presentation;

import com.sequence.anonymous.user.application.UserMatchPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-match-posts")
public class UserMatchPostController {
  private final UserMatchPostService userMatchPostService;
}
