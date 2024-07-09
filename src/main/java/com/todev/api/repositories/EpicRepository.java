package com.todev.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todev.api.domain.epic.Epic;

public interface EpicRepository extends JpaRepository<Epic, UUID> {

  
}
