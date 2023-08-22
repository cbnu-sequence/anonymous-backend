package com.sequence.anonymous.user.domain;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.matchPost.domain.MatchPost;
import com.sequence.anonymous.user.domain.User;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import org.springframework.data.mongodb.core.aggregation.PrefixingDelegatingAggregationOperationContext;

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
  private UserMatchPostRole role;

  protected UserMatchPost() {
  }

  public UserMatchPost(MatchPost matchPost, User user, UserMatchPostRole role) {
    Preconditions.checkArgument(matchPost != null, "matchPost must be provided");
    Preconditions.checkArgument(user != null, "user must be provided");
    Preconditions.checkArgument(role != null, "role must be provided");

    this.user = user;
    this.matchPost = matchPost;
    this.role = role;
  }
}
