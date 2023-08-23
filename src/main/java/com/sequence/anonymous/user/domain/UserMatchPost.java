package com.sequence.anonymous.user.domain;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.matchpost.domain.MatchPost;
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
public class UserMatchPost {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "matchPost_id")
  private MatchPost matchPost;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Enumerated(EnumType.STRING)
  private MatchPostRole role;

  protected UserMatchPost() {
  }

  public UserMatchPost(MatchPost matchPost, User user, MatchPostRole role) {
    Preconditions.checkArgument(matchPost != null, "matchPost must be provided");
    Preconditions.checkArgument(user != null, "user must be provided");
    Preconditions.checkArgument(role != null, "role must be provided");

    this.user = user;
    this.matchPost = matchPost;
    this.role = role;
  }
}
