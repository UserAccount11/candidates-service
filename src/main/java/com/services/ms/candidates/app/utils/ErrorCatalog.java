package com.services.ms.candidates.app.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

  CANDIDATE_NOT_FOUND("ERR_CANDIDATE_001", "Candidate not found."),
  INVALID_CANDIDATE("ERR_CANDIDATE_002", "Invalid candidate parameters."),
  GENERIC_ERROR("ERR_GEN_001", "An unexpected error occurred.");

  private final String code;
  private final String message;

  ErrorCatalog(String code, String message) {
    this.code = code;
    this.message = message;
  }

}
