package com.todev.api.domain.epic;

import java.util.Date;
import java.util.UUID;

import com.todev.api.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "epic")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Epic {
  @Id
  @GeneratedValue
  private UUID id;
  private String title;
  private String description;
  private Boolean status;
  private Date createdAt;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}
