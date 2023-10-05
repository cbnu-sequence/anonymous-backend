package com.sequence.anonymous.user.application;

import com.sequence.anonymous.user.domain.repository.TagRepository;
import com.sequence.anonymous.user.domain.tag.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TagService {

  private final TagRepository tagRepository;


  public Tag findById(Long id){
    return tagRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found: "+id));
  }
}