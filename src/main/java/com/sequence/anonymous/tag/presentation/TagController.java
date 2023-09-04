package com.sequence.anonymous.tag.presentation;

import com.sequence.anonymous.tag.application.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
public class TagController {
  private final TagService tagService;
}
