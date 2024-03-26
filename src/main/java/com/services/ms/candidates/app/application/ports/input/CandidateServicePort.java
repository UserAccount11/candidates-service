package com.services.ms.candidates.app.application.ports.input;

import com.services.ms.candidates.app.domain.model.Candidate;

import java.util.List;

public interface CandidateServicePort {

  Candidate findById(Long id);
  List<Candidate> findAll();
  Candidate save(Candidate candidate);
  Candidate update(Long id, Candidate candidate);
  void deleteById(Long id);

}
