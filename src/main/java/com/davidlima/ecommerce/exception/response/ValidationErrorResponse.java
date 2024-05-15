package com.davidlima.ecommerce.exception.response;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Description of ValidationErrorResponse.
 *
 * @author David Lima
 */

@Setter
@Getter
@NoArgsConstructor
public class ValidationErrorResponse {

  private int code;
  private String error;
  private List<FieldErrorMode> errors;
}
