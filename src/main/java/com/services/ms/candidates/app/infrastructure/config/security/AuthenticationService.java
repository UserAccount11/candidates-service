package com.services.ms.candidates.app.infrastructure.config.security;

import com.services.ms.candidates.app.domain.exception.CandidateNotFoundException;
import com.services.ms.candidates.app.domain.model.Candidate;
import com.services.ms.candidates.app.infrastructure.input.rest.model.request.LoginRequest;
import com.services.ms.candidates.app.infrastructure.output.persistence.mapper.CandidatePersistenceMapper;
import com.services.ms.candidates.app.infrastructure.output.persistence.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final AuthenticationManager authenticationManager;
  private final CandidateRepository repository;
  private final CandidatePersistenceMapper mapper;

  public Candidate authenticate(LoginRequest input) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            input.getEmail(),
            input.getPassword()
        )
    );

    return repository.findByEmail(input.getEmail())
        .map(mapper::toCandidate)
        .orElseThrow(CandidateNotFoundException::new);
  }

}