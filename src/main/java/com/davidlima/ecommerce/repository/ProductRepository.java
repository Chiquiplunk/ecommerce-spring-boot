package com.davidlima.ecommerce.repository;

import com.davidlima.ecommerce.entity.Product;
import org.springframework.data.domain.Pageable;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description of ProductRepository.
 *
 * @author David Lima
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID >{

  Page<Product> findByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);
}
