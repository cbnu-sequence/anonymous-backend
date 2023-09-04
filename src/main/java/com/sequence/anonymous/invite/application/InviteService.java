package com.sequence.anonymous.invite.application;

import com.sequence.anonymous.invite.domain.repository.InviteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InviteService {
  private final InviteRepository inviteRepository;
}
