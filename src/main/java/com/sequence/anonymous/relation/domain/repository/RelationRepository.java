package com.sequence.anonymous.relation.domain.repository;

import com.sequence.anonymous.relation.domain.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationRepository extends JpaRepository<Relation, Long> {

}
