package com.services.ms.candidates.app.infrastructure.input.rest;

import com.services.ms.candidates.app.domain.exception.CandidateNotFoundException;
import com.services.ms.candidates.app.infrastructure.input.rest.model.response.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

import static com.services.ms.candidates.app.utils.ErrorCatalog.CANDIDATE_NOT_FOUND;
import static com.services.ms.candidates.app.utils.ErrorCatalog.GENERIC_ERROR;
import static com.services.ms.candidates.app.utils.ErrorCatalog.INVALID_CANDIDATE;

@RestControllerAdvice
public class GlobalControllerAdvice {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(CandidateNotFoundException.class)
  public ErrorResponse handleStudentNotFoundException() {
    return ErrorResponse.builder()
        .code(CANDIDATE_NOT_FOUND.getCode())
        .message(CANDIDATE_NOT_FOUND.getMessage())
        .timestamp(LocalDateTime.now())
        .build();
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ErrorResponse handleMethodArgumentNotValidException(
      MethodArgumentNotValidException exception) {
    BindingResult result = exception.getBindingResult();

    return ErrorResponse.builder()
        .code(INVALID_CANDIDATE.getCode())
        .message(INVALID_CANDIDATE.getMessage())
        .details(result.getFieldErrors()
            .stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.toList()))
        .timestamp(LocalDateTime.now())
        .build();
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public ErrorResponse handleGenericError(Exception exception) {
    return ErrorResponse.builder()
        .code(GENERIC_ERROR.getCode())
        .message(GENERIC_ERROR.getMessage())
        .details(Collections.singletonList(exception.getMessage()))
        .timestamp(LocalDateTime.now())
        .build();
  }

}
