package com.davidlima.ecommerce.service;

import com.davidlima.ecommerce.dto.PageDto;
import com.davidlima.ecommerce.dto.ProductDto;
import com.davidlima.ecommerce.entity.Product;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Description of ProductService.
 *
 * @author David Lima
 */

public interface ProductService {

  Product save(ProductDto productDto);

  Product getById(UUID id);

  Page<Product> getProduct(Pageable pageable);

  PageDto<Product> getProductsFiltered(Double minPrice, Double maxPrice, Pageable pageable);

}
