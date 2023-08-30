package com.sequence.anonymous.user.domain;

import io.lettuce.core.dynamic.annotation.CommandNaming;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
@Entity
public class College {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "college_id")
  private Long id;

  @OneToMany
  private List<User> user = new ArrayList<>();

  @OneToMany
  private List<Department> department = new ArrayList<>();

  @Column(name = "name")
  String name;

  @Column(name = "Locaton")
  String location;


}
