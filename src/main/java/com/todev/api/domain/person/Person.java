package com.todev.api.domain.person;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Person
 */
@Table(name = "person")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

  @Id
  @GeneratedValue
  private UUID id;
  private String fullName;
  private String email;
  private String phone;
  private String job;
}
