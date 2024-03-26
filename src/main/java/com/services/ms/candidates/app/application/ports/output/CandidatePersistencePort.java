package com.services.ms.candidates.app.application.ports.output;

import com.services.ms.candidates.app.domain.model.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidatePersistencePort {

  Optional<Candidate> findById(Long id);
  List<Candidate> findAll();
  Candidate save(Candidate candidate);
  void deleteById(Long id);

}
