package com.davidlima.ecommerce.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Description of OrderDto.
 *
 * @author David Lima
 */

@NoArgsConstructor
@Getter
@Setter
public class OrderDto {

  private String comment;

  @JsonProperty(access = Access.READ_ONLY)
  private double totalPrice;

  List<OrderItemDto> items;
}
