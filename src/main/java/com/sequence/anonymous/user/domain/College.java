package com.sequence.anonymous.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
@Entity
public class College {

  @GeneratedValue @Id
  @Column(name = "college_id")
  @OneToMany(mappedBy = "User")
  private List<User> collegeUserList = new ArrayList<>();

  @Column(name = "name")
  String name;

  @Column(name = "Locaton")
  String location;
}
