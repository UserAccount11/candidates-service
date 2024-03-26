package com.services.ms.candidates.app.infrastructure.input.rest;


import com.services.ms.candidates.app.domain.model.Candidate;
import com.services.ms.candidates.app.infrastructure.config.security.AuthenticationService;
import com.services.ms.candidates.app.infrastructure.config.security.JwtProvider;
import com.services.ms.candidates.app.infrastructure.input.rest.model.request.LoginRequest;
import com.services.ms.candidates.app.infrastructure.input.rest.model.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final JwtProvider jwtProvider;
  private final AuthenticationService authenticationService;

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest loginRequest) {
    Candidate candidate = authenticationService.authenticate(loginRequest);

    String jwtToken = jwtProvider.generateToken(
        new User(candidate.getEmail(), candidate.getPassword(), Collections.emptyList()));

    LoginResponse loginResponse = LoginResponse.builder()
        .token(jwtToken)
        .expiresIn(jwtProvider.getExpirationTime())
        .build();

    return ResponseEntity.ok(loginResponse);
  }

}
