package com.davidlima.ecommerce.repository;

import com.davidlima.ecommerce.entity.Category;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description of CategoryRepository.
 * paquete dedicado para la capa de acceso a datos.
 *
 * @author David Lima
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
