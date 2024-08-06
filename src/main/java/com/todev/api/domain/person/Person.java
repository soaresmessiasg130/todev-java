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

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }
}
