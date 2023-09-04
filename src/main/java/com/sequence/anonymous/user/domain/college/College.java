package com.sequence.anonymous.user.domain.college;

import com.sequence.anonymous.user.domain.user.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
@Entity
public class College {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "college_id")
  private static Long id;

  @OneToMany
  private List<User> user = new ArrayList<>();

  @OneToMany
  private List<Department> department = new ArrayList<>();

  @Column(name = "name")
  private String name;

  @Column(name = "Locaton")
  private String location;


}
