package com.sequence.anonymous.matchpost.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchPostService {
  private final MatchPostService matchPostService;
}
