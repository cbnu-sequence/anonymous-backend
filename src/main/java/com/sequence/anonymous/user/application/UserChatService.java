package com.sequence.anonymous.user.application;

import com.sequence.anonymous.user.domain.repository.UserChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserChatService {
  private final UserChatRepository userChatRepository;
}
