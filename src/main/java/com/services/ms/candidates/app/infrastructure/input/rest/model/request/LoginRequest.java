package com.services.ms.candidates.app.infrastructure.input.rest.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

  @Email(message = "Field email must have a valid format.")
  private String email;

  @NotNull(message = "Field password cannot be empty or null.")
  private String password;

}
