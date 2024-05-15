package com.davidlima.ecommerce.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

/**
 * Description of ProductDto.
 *
 * @author David Lima
 */

@NoArgsConstructor
@Getter
@Setter
public class  ProductDto {

  @NotBlank(message = "Nombre no puede estar en blanco")
  @Size(min = 3, max = 70, message = "nombre debe estar entre 3 y 70 caracteres")
  private String name;

  @NotBlank(message = "Description no puede estar en blanco")
  private String description;

  @URL
  private String imageUrl;

  @DecimalMin(value = "0.0", inclusive = false, message = "El precio no puede ser negativo")
  private double price;

  @Min(value = 0, message = "El stock no puede ser negativo")
  private int stock;

  @NotNull
  private boolean activate;

  @NotNull
  private UUID categoryId;
}
