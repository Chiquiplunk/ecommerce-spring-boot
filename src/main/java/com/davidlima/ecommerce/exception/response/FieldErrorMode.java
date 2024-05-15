package com.davidlima.ecommerce.exception.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Description of FieldErrorMode.
 *
 * @author David Lima
 */

@Setter
@Getter
@NoArgsConstructor
public class FieldErrorMode {

  private String field;
  private String message;
  private String code;
}
