package com.services.ms.candidates.app.infrastructure.config.security;

import com.services.ms.candidates.app.infrastructure.output.persistence.entity.CandidateEntity;
import com.services.ms.candidates.app.infrastructure.output.persistence.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final CandidateRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    CandidateEntity entity = repository.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

    return new User(
        entity.getEmail(),
        entity.getPassword(),
        new ArrayList<>()
    );
  }

}