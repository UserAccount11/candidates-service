package com.services.ms.candidates.app.application.service;

import com.services.ms.candidates.app.application.ports.input.CandidateServicePort;
import com.services.ms.candidates.app.application.ports.output.CandidatePersistencePort;
import com.services.ms.candidates.app.domain.exception.CandidateNotFoundException;
import com.services.ms.candidates.app.domain.model.Candidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService implements CandidateServicePort {

  private final CandidatePersistencePort persistencePort;

  @Override
  public Candidate findById(Long id) {
    return persistencePort.findById(id)
        .orElseThrow(CandidateNotFoundException::new);
  }

  @Override
  public List<Candidate> findAll() {
    return persistencePort.findAll();
  }

  @Override
  public Candidate save(Candidate candidate) {
    return persistencePort.save(candidate);
  }

  @Override
  public Candidate update(Long id, Candidate candidate) {
    return persistencePort.findById(id)
        .map(candidateDb -> {
          candidateDb.setFirstname(candidate.getFirstname());
          candidateDb.setLastname(candidate.getLastname());
          candidateDb.setEmail(candidate.getEmail());
          candidateDb.setGender(candidate.getGender());
          candidateDb.setSalaryExpected(candidate.getSalaryExpected());
          candidateDb.setIntegrationDate(candidate.getIntegrationDate());
          return persistencePort.save(candidateDb);
        })
        .orElseThrow(CandidateNotFoundException::new);
  }

  @Override
  public void deleteById(Long id) {
    if (persistencePort.findById(id).isEmpty()) {
      throw new CandidateNotFoundException();
    }
    persistencePort.deleteById(id);
  }
}
