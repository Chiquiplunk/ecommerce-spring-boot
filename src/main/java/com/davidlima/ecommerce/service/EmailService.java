package com.davidlima.ecommerce.service;

import com.davidlima.ecommerce.dto.EmailNotification;

/**
 * Description of EmailService.
 *
 * @author David Lima
 */

public interface EmailService {

  void send(EmailNotification emailNotification);
}
