package com.davidlima.ecommerce.controller;

import com.davidlima.ecommerce.dto.OrderDto;
import com.davidlima.ecommerce.repository.OrderRepository;
import com.davidlima.ecommerce.service.OrderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description of OrderController.
 *
 * @author David Lima
 */

@RestController
@RequestMapping("orders")
@AllArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class OrderController {

  private OrderService orderService;
  private OrderRepository orderRepository;

  @PostMapping

  private ResponseEntity<String> save(@RequestBody OrderDto dto){
    String message = orderService.save(dto);
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(message);
  }

  /*@GetMapping("/{id}/price/total")
  public String getTotalPrice(@PathVariable UUID id){
    double total = orderRepository.getTotalPriceByOrderId(id.toString()); // query native
    double total2 = orderRepository.getTotalPrice(id); // jpql

    return "Query nativa: " + total + " JPQL: " + total2;
  }*/

  @GetMapping("/{id}")

  public ResponseEntity<OrderDto> getById(@PathVariable UUID id){
    OrderDto orderDto = orderService.getById(id);
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(orderDto);
  }
}
