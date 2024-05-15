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
 * Description of Category.
 *
 * @author David Lima
 */

@Data
@Entity
@Table(name = "categories")
public class Category {

  @Id
  @GeneratedValue
  @JdbcTypeCode(Types.VARCHAR)
  private UUID id;

  @Column(nullable = false, length = 30)
  private String name;

  @Column(length = 255)
  private String description;

}
