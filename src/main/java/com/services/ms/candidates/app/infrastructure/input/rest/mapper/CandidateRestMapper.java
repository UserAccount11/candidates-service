package com.services.ms.candidates.app.infrastructure.input.rest.mapper;

import com.services.ms.candidates.app.domain.model.Candidate;
import com.services.ms.candidates.app.infrastructure.input.rest.model.request.CandidateCreateRequest;
import com.services.ms.candidates.app.infrastructure.input.rest.model.response.CandidateResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CandidateRestMapper {

  Candidate toCandidate(CandidateCreateRequest request);

  CandidateResponse toCandidateResponse(Candidate candidate);

  List<CandidateResponse> toCandidateResponseList(List<Candidate> candidateList);

}
