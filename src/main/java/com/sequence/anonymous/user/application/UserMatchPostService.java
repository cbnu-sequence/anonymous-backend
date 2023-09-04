package com.sequence.anonymous.user.application;

import com.sequence.anonymous.user.domain.repository.UserMatchPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMatchPostService {
  private final UserMatchPostRepository userMatchPostRepository;
}
