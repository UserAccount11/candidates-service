package com.services.ms.candidates.app.infrastructure.output.persistence;

import com.services.ms.candidates.app.application.ports.output.CandidatePersistencePort;
import com.services.ms.candidates.app.domain.model.Candidate;
import com.services.ms.candidates.app.infrastructure.output.persistence.mapper.CandidatePersistenceMapper;
import com.services.ms.candidates.app.infrastructure.output.persistence.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CandidatePersistenceAdapter implements CandidatePersistencePort {

  private final CandidateRepository repository;
  private final CandidatePersistenceMapper mapper;

  @Override
  public Optional<Candidate> findById(Long id) {
    return repository.findById(id)
        .map(mapper::toCandidate);
  }

  @Override
  public List<Candidate> findAll() {
    return mapper.toCandidateList(repository.findAll());
  }

  @Override
  public Candidate save(Candidate candidate) {
    return mapper.toCandidate(
        repository.save(mapper.toCandidateEntity(candidate)));
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

}
