package com.sequence.anonymous.user.presentation;

import com.sequence.anonymous.user.application.TagService;
import com.sequence.anonymous.user.domain.dto.TagResponse;
import com.sequence.anonymous.user.domain.tag.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/personality-tags")
public class TagController {
  private final TagService tagService;

  @GetMapping("/")
  public ResponseEntity<List<Tag>>findAll(){

    List<Tag> tag = tagService.printAll();
    return ResponseEntity.status(HttpStatus.CREATED).body((List<Tag>) tag);
  }
}
