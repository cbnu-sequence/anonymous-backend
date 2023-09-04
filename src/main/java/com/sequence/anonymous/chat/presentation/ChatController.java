package com.sequence.anonymous.chat.presentation;

import com.sequence.anonymous.chat.application.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chats")
public class ChatController {
  private final ChatService chatService;
}
