package com.davidlima.ecommerce.exception.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Description of ErrorResponse.
 *
 * @author David Lima
 */

@Getter
@Setter
@Builder
public class ErrorResponse {

  private int code;
  private String error;
  private String message;
}
