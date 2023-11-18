package com.sequence.anonymous.user.application;

import com.sequence.anonymous.user.domain.repository.TagRepository;
import com.sequence.anonymous.user.domain.tag.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TagService {

  private final TagRepository tagRepository;


  public List<Tag> findAll(){
    return tagRepository.findAll();  }
}