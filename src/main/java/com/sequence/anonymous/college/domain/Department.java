package com.sequence.anonymous.college.domain;

import com.google.common.base.Preconditions;
import com.sequence.anonymous.college.domain.presentation.dto.DepartmentUpdateDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "college_id")
  private College college;

  protected Department() {
  }

  public Department(String name, College college) {
    Preconditions.checkArgument(name != null, "name must be provided");
    Preconditions.checkArgument(college != null, "college must be provided");

    this.id = null;
    this.name = name;
    this.college = college;
  }

  public void updateName(DepartmentUpdateDto dto) {
    this.name = dto.getName();
  }
}
