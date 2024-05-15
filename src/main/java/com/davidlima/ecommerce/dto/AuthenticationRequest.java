package com.davidlima.ecommerce.dto;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Description of AuthenticationRequest.
 *
 * @author David Lima
 */

@Builder
@Getter
@Setter
public class AuthenticationRequest {

  @Email
  private String email;
  private String password;
}
