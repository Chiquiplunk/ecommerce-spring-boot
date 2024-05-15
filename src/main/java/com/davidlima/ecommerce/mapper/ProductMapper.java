package com.davidlima.ecommerce.mapper;

import com.davidlima.ecommerce.dto.PageDto;
import com.davidlima.ecommerce.dto.ProductDto;
import com.davidlima.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * Description of ProductMapper.
 *
 * @author David Lima
 */

@Component
public class ProductMapper {

  public PageDto<Product> fromEntity(Page<Product> page){
    PageDto<Product> pageDto = new PageDto<>();
    pageDto.setContent(page.getContent());
    pageDto.setPageNumber(page.getNumber());
    pageDto.setPageSize(page.getSize());
    pageDto.setLast(page.isLast());
    pageDto.setTotalPages(page.getTotalPages());
    pageDto.setTotalElements(page.getTotalElements());
    return pageDto;
  }

  public Product fromDto(ProductDto dto){
    Product product = new Product();
    product.setName(dto.getName());
    product.setDescription(dto.getDescription());
    product.setPrice(dto.getPrice());
    product.setStock(dto.getStock());
    product.setActivate(dto.isActivate());
    product.setImageUrl(dto.getImageUrl());
    return product;
  }
}
