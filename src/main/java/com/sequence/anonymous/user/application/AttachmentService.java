package com.sequence.anonymous.user.application;

import com.sequence.anonymous.user.domain.repository.AttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttachmentService {
  private final AttachmentRepository attachmentRepository;
}
