package com.todev.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todev.api.domain.user.UserStatusRequestDto;
import com.todev.api.domain.user.UserStatusResponseDto;
import com.todev.api.services.UserService;

/**
 * UserController
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  private UserService _userService;

  @GetMapping("/status")
  public ResponseEntity<UserStatusResponseDto> status(@RequestBody UserStatusRequestDto request) {
    Boolean userExists = _userService.getUserExists(request.login());

    UserStatusResponseDto res = new UserStatusResponseDto(userExists);

    return ResponseEntity.ok(res);
  }
}
