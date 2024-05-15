package com.davidlima.ecommerce.controller;

import com.davidlima.ecommerce.dto.PageDto;
import com.davidlima.ecommerce.dto.ProductDto;
import com.davidlima.ecommerce.entity.Product;
import com.davidlima.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description of ProductController.
 *
 * @author David Lima
 */

@Tag(name = "Product")
@AllArgsConstructor
@RestController
@RequestMapping("products")

public class ProductController {

  private ProductService productService;

  @Operation(
      summary = "Guardar un nuevo producto"
  )

  @PostMapping
  @SecurityRequirement(name = "bearerAuth")
  public ResponseEntity<Product> save(@RequestBody @Valid ProductDto dto){
    Product productSaved = productService.save(dto);
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(productSaved);
  }

  @Operation(
      summary = "Obtener un producto por su ID"
  )
  @GetMapping("/{id}")
  public ResponseEntity<Product> getById(@PathVariable UUID id){
    Product productFound = productService.getById(id);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(productFound);
  }

  @Hidden
  @GetMapping("/pageable")
  public ResponseEntity<Page<Product>> getProductsPageable(@RequestParam int page,@RequestParam int size){
    Pageable pageable = PageRequest.of(page, size);
    Page<Product> productPage = productService.getProduct(pageable);
    return ResponseEntity
        .status(HttpStatus.OK )
        .body(productPage);
  }

  @Operation(
      summary = "Obtener productos con compaginación y filtrado"
  )
  @GetMapping
  public ResponseEntity<PageDto<Product>> getProductsFiltered(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "20") int size,
      @RequestParam(required = false) Double minPrice,
      @RequestParam(required = false) Double maxPrice,
      @RequestParam(defaultValue = "id") String sortField,
      @RequestParam(defaultValue = "asc") String sortOrder
  ){
    if (minPrice == null){
      minPrice = Double.MIN_VALUE;
    }
    if (maxPrice == null){
      maxPrice = Double.MAX_VALUE;
    }

    Sort sort = Sort.by(Sort.Direction.fromString(sortOrder), sortField);
    Pageable pageable = PageRequest.of(page, size, sort);

    PageDto<Product> productPage = productService.getProductsFiltered(minPrice,maxPrice,pageable);
    return ResponseEntity
        .status(HttpStatus.OK )
        .body(productPage);
  }
}
