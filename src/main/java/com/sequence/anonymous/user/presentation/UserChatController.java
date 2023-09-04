package com.sequence.anonymous.user.presentation;

import com.sequence.anonymous.user.application.UserChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-chats")
public class UserChatController {
  private final UserChatService userChatService;
}
