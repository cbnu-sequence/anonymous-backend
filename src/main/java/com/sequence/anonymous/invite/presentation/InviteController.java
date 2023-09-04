package com.sequence.anonymous.invite.presentation;

import com.sequence.anonymous.invite.application.InviteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invites")
public class InviteController {
  private final InviteService inviteService;
}
