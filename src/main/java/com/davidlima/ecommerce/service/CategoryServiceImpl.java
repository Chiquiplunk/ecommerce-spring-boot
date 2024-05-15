package com.davidlima.ecommerce.service;

import com.davidlima.ecommerce.entity.Category;
import com.davidlima.ecommerce.repository.CategoryRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Description of CategoryServiceImpl.
 *
 * @author David Lima
 */

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

  // Esto es inyección de métodos
  private CategoryRepository categoryRepository;

  @Override
  public List<Category> getAll() {
    return categoryRepository.findAll();
  }

  @Override
  public Category getById(UUID id) {
    return categoryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Recurso no encontrado"));
  }
}
