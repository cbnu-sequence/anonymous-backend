package com.sequence.anonymous.user.presentation;

import com.sequence.anonymous.user.application.TagService;
import com.sequence.anonymous.user.domain.tag.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/personality-tags")
public class TagController {
    private final TagService tagService;

    @GetMapping("")
    public ResponseEntity<List<Tag>> findAll() {

        List<Tag> tag = tagService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(tag);
    }
}
