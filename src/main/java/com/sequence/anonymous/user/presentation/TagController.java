package com.sequence.anonymous.user.presentation;

import com.sequence.anonymous.user.application.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tags")
public class TagController {

  private final TagService tagService;
}
