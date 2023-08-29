package com.sequence.anonymous.user.domain.user;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.user.domain.tag.Tag;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
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
    this(null, user, tag);
  }

  private UserTag(Long id, User user, Tag tag) {
    Preconditions.checkArgument(user != null, "user must be provided.");
    Preconditions.checkArgument(tag != null, "tag must be provided.");

    this.id = id;
    this.user = user;
    this.tag = tag;
  }
}
