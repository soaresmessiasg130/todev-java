package com.todev.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todev.api.domain.task.Task;

interface TaskRepository extends JpaRepository<Task, UUID> {

  
}
