package com.sequence.anonymous.user.domain;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.tag.domain.Tag;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class UserTag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "tag_id")
  private Tag tag;

  protected UserTag() {
  }

  public UserTag(User user, Tag tag) {
    Preconditions.checkArgument(user != null, "User must be provided");
    Preconditions.checkArgument(tag != null, "Tag must be provided");

    this.id = null;
    this.user = user;
    this.tag = tag;
  }
}
