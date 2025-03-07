package com.davidlima.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

/**
 * Description of ConfirmationToken.
 *
 * @author David Lima
 */

@Entity
@Getter
@Setter
@Table(name = "confirmation_tokens")
public class ConfirmationToken {

  @Id
  @GeneratedValue
  @JdbcTypeCode(Types.VARCHAR)
  private UUID id;

  @Column(nullable = false)
  private String token;

  @Column(nullable = false)
  private LocalDateTime createdAt = LocalDateTime.now();
  private LocalDateTime confirmedAt;

  @Column(nullable = false)
  private LocalDateTime expiresAt;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public ConfirmationToken() {
  }

  public ConfirmationToken(String token, LocalDateTime expiresAt, User user) {
    this.token = token;
    this.expiresAt = expiresAt;
    this.user = user;
  }
}
