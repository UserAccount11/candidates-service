package com.services.ms.candidates.app.infrastructure.input.rest;

import com.services.ms.candidates.app.application.ports.input.CandidateServicePort;
import com.services.ms.candidates.app.infrastructure.input.rest.mapper.CandidateRestMapper;
import com.services.ms.candidates.app.infrastructure.input.rest.model.request.CandidateCreateRequest;
import com.services.ms.candidates.app.infrastructure.input.rest.model.response.CandidateResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/candidates")
@RequiredArgsConstructor
public class CandidateRestController {

  private final CandidateServicePort servicePort;
  private final CandidateRestMapper restMapper;

  @GetMapping("/v1/api")
  public List<CandidateResponse> findAll() {
    return restMapper.toCandidateResponseList(servicePort.findAll());
  }

  @GetMapping("/v1/api/{id}")
  public CandidateResponse findById(@PathVariable Long id) {
    return restMapper.toCandidateResponse(servicePort.findById(id));
  }

  @PostMapping("/v1/api")
  public ResponseEntity<CandidateResponse> save(@Valid @RequestBody CandidateCreateRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(restMapper.toCandidateResponse(
            servicePort.save(restMapper.toCandidate(request))));
  }

  @PutMapping("/v1/api/{id}")
  public CandidateResponse update(@PathVariable Long id,
                                  @Valid @RequestBody CandidateCreateRequest request) {
    return restMapper.toCandidateResponse(
        servicePort.update(id, restMapper.toCandidate(request)));
  }

  @DeleteMapping("/v1/api/{id}")
  public void delete(@PathVariable Long id) {
    servicePort.deleteById(id);
  }

}
