package com.example.apiiticbcn.controllers;

import com.example.apiiticbcn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/general")
public class GeneralController {

  private final UserRepository userRepository;

  @Autowired
  public GeneralController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/role/{email}")
  public ResponseEntity<Long> getRoleIdByEmail(@PathVariable String email) {
    Optional<Long> roleId = userRepository.findRoleIdByEmail(email);
    return roleId.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }
}