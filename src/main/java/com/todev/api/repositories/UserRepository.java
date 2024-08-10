package com.todev.api.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todev.api.domain.user.User;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, UUID> {
  
  Optional<User> findOneByLogin(String login);
}
