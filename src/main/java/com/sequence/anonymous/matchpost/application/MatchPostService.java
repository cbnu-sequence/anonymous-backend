package com.sequence.anonymous.matchpost.application;

import com.sequence.anonymous.matchpost.domain.repository.MatchPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MatchPostService {

  private final MatchPostRepository matchPostRepository;
}
