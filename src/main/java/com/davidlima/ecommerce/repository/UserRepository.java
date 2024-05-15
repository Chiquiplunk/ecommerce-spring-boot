package com.davidlima.ecommerce.repository;

import com.davidlima.ecommerce.entity.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description of UserRepository.
 *
 * @author David Lima
 */

public interface UserRepository extends JpaRepository<User, UUID> {

  boolean existsByEmail(String email);

  Optional<User> findByEmail(String email);
}
