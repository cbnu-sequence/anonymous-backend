package com.sequence.anonymous.chat.application;

import com.sequence.anonymous.chat.domain.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

  private final ChatRepository chatRepository;
}
