package com.sequence.anonymous.relation.application;

import com.sequence.anonymous.relation.domain.repository.RelationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RelationService {
  private final RelationRepository relationRepository;
}
