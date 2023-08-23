package com.sequence.anonymous.relation.domain;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.relation.presentation.dto.UpdateDto;
import com.sequence.anonymous.user.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Relation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user1_id")
  private User user1;

  @ManyToOne
  @JoinColumn(name = "user2_id")
  private User user2;

  @Column(length = 10)
  @Enumerated(EnumType.STRING)
  private Status status;

  protected Relation() {
  }

  public Relation(User user1, User user2, Status status) {
    Preconditions.checkArgument(user1 != null, "user1 must be provided");
    Preconditions.checkArgument(user2 != null, "user2 must be provided");
    Preconditions.checkArgument(status != null, "status must be provided");

    this.user1 = user1;
    this.user2 = user2;
    this.status = status;
  }

  public void updateStatus(UpdateDto dto) {
    this.status = dto.getStatus();
  }
}
