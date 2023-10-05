package com.sequence.anonymous.user.presentation;

import com.sequence.anonymous.user.application.TagService;
import com.sequence.anonymous.user.domain.dto.TagResponse;
import com.sequence.anonymous.user.domain.tag.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/personality-tags")
public class TagController {
  private final TagService tagService;

  public ResponseEntity<TagResponse> findTag(@PathVariable Long id){
    Tag tag = tagService.findById(id);


    return ResponseEntity.ok().body(new TagResponse(tag));
  }
}
