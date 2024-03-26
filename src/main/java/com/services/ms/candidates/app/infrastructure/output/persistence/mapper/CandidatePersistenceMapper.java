package com.services.ms.candidates.app.infrastructure.output.persistence.mapper;

import com.services.ms.candidates.app.domain.model.Candidate;
import com.services.ms.candidates.app.infrastructure.output.persistence.entity.CandidateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CandidatePersistenceMapper {

  PasswordEncoder encoder = new BCryptPasswordEncoder();

  @Mapping(target = "password", expression = "java(encodePassword(candidate))")
  CandidateEntity toCandidateEntity(Candidate candidate);

  Candidate toCandidate(CandidateEntity entity);

  List<Candidate> toCandidateList(List<CandidateEntity> entityList);

  default String encodePassword(Candidate candidate) {
    return encoder.encode(candidate.getPassword());
  }

}
