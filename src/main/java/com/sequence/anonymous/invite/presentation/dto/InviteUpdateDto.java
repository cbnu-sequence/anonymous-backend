package com.sequence.anonymous.invite.presentation.dto;

import com.sequence.anonymous.invite.domain.InviteStatus;
import lombok.Getter;

@Getter
public class InviteUpdateDto {

  private InviteStatus status;
}
