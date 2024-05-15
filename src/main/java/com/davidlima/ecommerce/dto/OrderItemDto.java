package com.davidlima.ecommerce.dto;

import com.davidlima.ecommerce.entity.Order;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Description of OrderItemDto.
 *
 * @author David Lima
 */

@NoArgsConstructor
@Getter
@Setter
public class OrderItemDto {

    private Integer quantity;
    private UUID productId;
}
