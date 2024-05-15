package com.davidlima.ecommerce.service;

import com.davidlima.ecommerce.entity.ConfirmationToken;

/**
 * Description of ConfirmationTokenService.
 *
 * @author David Lima
 */

public interface ConfirmationTokenService {

  void save(ConfirmationToken confirmationToken);

  ConfirmationToken getByToken(String token);

  void setConfirmedAt(ConfirmationToken confirmationToken);
}
