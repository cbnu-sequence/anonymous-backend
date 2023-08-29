package com.sequence.anonymous.chat.presentation;

import com.sequence.anonymous.chat.application.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chats")
public class ChatController {

  private final ChatService chatService;
}
