package com.davidlima.ecommerce.repository;

import com.davidlima.ecommerce.entity.ConfirmationToken;
import jakarta.websocket.server.ServerEndpoint;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description of ConfirmationTokenRepository.
 *
 * @author David Lima
 */

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, UUID> {

  Optional<ConfirmationToken> findByToken(String token);
}
