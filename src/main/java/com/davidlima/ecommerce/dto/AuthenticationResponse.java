package com.davidlima.ecommerce.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Description of AuthenticationResponse.
 *
 * @author David Lima
 */

@Builder
@Getter
@Setter
public class AuthenticationResponse {

  private String accessToken;
}
