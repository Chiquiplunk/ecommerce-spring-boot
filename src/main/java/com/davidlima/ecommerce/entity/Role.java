package com.davidlima.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Types;
import java.util.UUID;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;

/**
 * Description of Role.
 *
 * @author David Lima
 */

@Entity
@Data
@Table(name = "roles")
public class Role {

  @Id
  @GeneratedValue
  @JdbcTypeCode(Types.VARCHAR)
  private UUID id;
  @Column(
      length = 25,
      nullable = false,
      unique = true)
  private String name;
  private String description;
}
