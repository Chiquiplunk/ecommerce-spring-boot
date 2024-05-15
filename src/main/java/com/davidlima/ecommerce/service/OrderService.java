package com.davidlima.ecommerce.service;

import com.davidlima.ecommerce.dto.OrderDto;
import com.davidlima.ecommerce.entity.Order;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Description of OrderService.
 *
 * @author David Lima
 */

@Service
public interface OrderService {

  String save(OrderDto orderDto);

  OrderDto getById(UUID id);
}
