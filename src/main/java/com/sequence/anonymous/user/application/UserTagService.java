package com.sequence.anonymous.user.application;

import com.sequence.anonymous.user.domain.repository.UserTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserTagService {
  private final UserTagRepository userTagRepository;
}
