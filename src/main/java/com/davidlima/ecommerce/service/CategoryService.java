package com.davidlima.ecommerce.service;

import com.davidlima.ecommerce.entity.Category;
import java.util.List;
import java.util.UUID;

/**
 * Description of CategoryService.
 * Service para la lógica de negocio
 *
 * @author David Lima
 */

public interface CategoryService {

  List<Category> getAll();

  Category getById(UUID id);
}
