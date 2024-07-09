package com.todev.api.domain.task;

import java.util.Date;
import java.util.UUID;

import com.todev.api.domain.epic.Epic;

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

@Table(name = "task")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
  @Id
  @GeneratedValue
  private UUID id;
  private String title;
  private String desc;
  private String imageUrl;
  private Boolean done;
  private Date createdAt; 
  @ManyToOne
  @JoinColumn(name = "epic_id")
  private Epic epic;
}
