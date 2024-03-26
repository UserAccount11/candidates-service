package com.services.ms.candidates.app.infrastructure.input.rest.model.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.services.ms.candidates.app.domain.model.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCreateRequest {

  @NotEmpty(message = "Field firstname cannot be empty or null.")
  private String firstname;

  @NotEmpty(message = "Field lastname cannot be empty or null.")
  private String lastname;

  @Email(message = "Field email must have a valid format.")
  private String email;

  @NotNull(message = "Field password cannot be empty or null.")
  private String password;

  @NotNull(message = "Field gender cannot be null.")
  private Gender gender;

  @NotNull(message = "Field salary_expected cannot be null.")
  private BigDecimal salaryExpected;

  @JsonDeserialize(using = LocalDateDeserializer.class)
  @NotNull(message = "Field integration_date cannot be null.")
  private LocalDate integrationDate;

}
