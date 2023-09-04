package com.sequence.anonymous.tag.application;

import com.sequence.anonymous.tag.domain.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {
  private final TagRepository tagRepository;
}
