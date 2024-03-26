package com.services.ms.candidates.app.domain.model;

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
public class Candidate {

  private Long id;
  private String firstname;
  private String lastname;
  private String email;
  private String password;
  private Gender gender;
  private BigDecimal salaryExpected;
  private LocalDate integrationDate;

}
