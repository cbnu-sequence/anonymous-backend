package com.sequence.anonymous.chat.application;

import com.sequence.anonymous.chat.domain.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatService {

  private final ChatRepository chatRepository;
}
