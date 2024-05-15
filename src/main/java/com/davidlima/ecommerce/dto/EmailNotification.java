package com.davidlima.ecommerce.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Description of EmailNotification.
 *
 * @author David Lima
 */

@Builder
@Getter
@Setter
public class EmailNotification {

  String to;
  String subject;
  String body;
  boolean hasTemplate;
}
