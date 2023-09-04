package com.sequence.anonymous.matchpost.presentation;

import com.sequence.anonymous.matchpost.application.MatchPostService;
import com.sequence.anonymous.matchpost.domain.repository.MatchPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/match-posts")
public class MatchPostController {
  private final MatchPostService matchPostService;
}
