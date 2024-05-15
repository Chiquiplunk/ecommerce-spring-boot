package com.davidlima.ecommerce.service;

import com.davidlima.ecommerce.dto.PageDto;
import com.davidlima.ecommerce.dto.ProductDto;
import com.davidlima.ecommerce.entity.Category;
import com.davidlima.ecommerce.entity.Product;
import com.davidlima.ecommerce.mapper.ProductMapper;
import com.davidlima.ecommerce.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * Description of ProductServiceImpl.
 *
 * @author David Lima
 */

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

  private ProductRepository productRepository;
  private CategoryService categoryService;
  private ProductMapper productMapper;


  @Override
  public Product save(ProductDto dto) {
    Category category = categoryService.getById(dto.getCategoryId());
    Product product = productMapper.fromDto(dto);
    product.setCategory(category);
    return productRepository.save(product);
  }

  @Override
  public Product getById(UUID id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
  }

  @Override
  public Page<Product> getProduct(Pageable pageable) {
    return productRepository.findAll(pageable);
  }

  @Override
  public PageDto<Product> getProductsFiltered(Double minPrice, Double maxPrice, Pageable pageable) {
    Page<Product> page = productRepository.findByPriceBetween(minPrice,maxPrice,pageable);
    return productMapper.fromEntity(page);
  }

}
