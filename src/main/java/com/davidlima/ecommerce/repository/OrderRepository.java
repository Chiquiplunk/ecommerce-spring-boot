package com.davidlima.ecommerce.repository;

import com.davidlima.ecommerce.entity.Order;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Description of OrderRepository.
 *
 * @author David Lima
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

  @Query(value = "SELECT SUM(products.price * order_items.quantity) "
      + "FROM orders "
      + "JOIN order_items ON orders.id = order_items.order_id "
      + "JOIN products ON order_items.product_id = products.id "
      + "WHERE orders.id = ?1",
      nativeQuery = true)
  Double getTotalPriceByOrderId(String orderId);

  @Query(value = "SELECT SUM(p.price * oi.quantity) "
      + "FROM Order o "
      + "JOIN o.items oi "
      + "JOIN oi.product p "
      + "WHERE o.id = ?1")
  Double getTotalPrice(UUID orderId);
}
