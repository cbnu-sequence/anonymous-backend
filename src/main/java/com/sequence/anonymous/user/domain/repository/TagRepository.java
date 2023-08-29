package com.sequence.anonymous.user.domain.repository;

import com.sequence.anonymous.user.domain.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
