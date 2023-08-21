package com.sequence.anonymous.user.domain;

import com.google.common.base.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.File;
import java.util.UUID;
import lombok.Getter;

@Entity
@Getter
public class Attachment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private UUID name;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Enumerated(EnumType.STRING)
  private FileType type;

  protected Attachment() {
  }

  public Attachment(UUID name, User user, FileType type) {
    Preconditions.checkArgument(name != null, "name must be provided");
    Preconditions.checkArgument(user != null, "user must be provided");
    Preconditions.checkArgument(type != null, "type must be provided");

    this.id = null;
    this.name = name;
    this.user = user;
    this.type = type;
  }
}
