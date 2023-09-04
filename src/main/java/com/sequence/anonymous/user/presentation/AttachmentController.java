package com.sequence.anonymous.user.presentation;

import com.sequence.anonymous.user.application.AttachmentService;
import com.sequence.anonymous.user.domain.repository.AttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attachments")
public class AttachmentController {
  private final AttachmentService attachmentService;
}
