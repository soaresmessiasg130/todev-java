package com.todev.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todev.api.domain.user.User;
import com.todev.api.repositories.UserRepository;

/**
 * UserService
 */
@Service
public class UserService {

  @Autowired
  private UserRepository _userRepository;

  public Boolean getUserExists(String login) {
    Optional<User> res = _userRepository.findOneByLogin(login);

    return res.isPresent();
  } 
}
