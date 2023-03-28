package com.restaurant.backend.controller;

import com.restaurant.backend.models.client.LoginRequest;
import com.restaurant.backend.models.client.LoginResponse;
import com.restaurant.backend.models.db.DbUser;
import com.restaurant.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    public ResponseEntity<LoginResponse> createUser(@Valid @RequestBody DbUser user){
          return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest){
          return new ResponseEntity<>(userService.loginUser(loginRequest),HttpStatus.OK);
    }
}
