package com.sequence.anonymous.matchpost.application;

import com.sequence.anonymous.matchpost.domain.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatService {

  private final ChatRepository chatRepository;
}
