package com.sequence.anonymous.relation.presentation;

import com.sequence.anonymous.relation.application.RelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
@RequestMapping("/relations")
public class RelationController {
private final RelationService relationService;
}
