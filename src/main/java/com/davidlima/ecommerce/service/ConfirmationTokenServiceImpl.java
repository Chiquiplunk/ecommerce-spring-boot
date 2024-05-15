package com.davidlima.ecommerce.service;

import com.davidlima.ecommerce.entity.ConfirmationToken;
import com.davidlima.ecommerce.repository.ConfirmationTokenRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Description of ConfirmationTokenServiceImpl.
 *
 * @author David Lima
 */

@Service
@AllArgsConstructor
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService{

  @Override
  public void setConfirmedAt(ConfirmationToken confirmationToken) {
    confirmationToken.setConfirmedAt(LocalDateTime.now());
    confirmationTokenRepository.save(confirmationToken);
  }

  @Override
  public ConfirmationToken getByToken(String token) {
    return confirmationTokenRepository.findByToken(token)
        .orElseThrow(() -> new EntityNotFoundException("Recurso no encontrado"));
  }

  private ConfirmationTokenRepository confirmationTokenRepository;

  @Override
  public void save(ConfirmationToken confirmationToken) {
    confirmationTokenRepository.save(confirmationToken);
  }
}
