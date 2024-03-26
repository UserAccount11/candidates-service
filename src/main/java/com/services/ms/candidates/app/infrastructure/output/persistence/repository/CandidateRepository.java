package com.services.ms.candidates.app.infrastructure.output.persistence.repository;

import com.services.ms.candidates.app.infrastructure.output.persistence.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<CandidateEntity, Long> {

  Optional<CandidateEntity> findByEmail(String email);

}
