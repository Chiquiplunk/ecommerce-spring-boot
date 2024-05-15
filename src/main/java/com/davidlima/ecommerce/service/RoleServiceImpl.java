package com.davidlima.ecommerce.service;

import com.davidlima.ecommerce.entity.Role;
import com.davidlima.ecommerce.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Description of RoleServiceImpl.
 *
 * @author David Lima
 */

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService{

  private RoleRepository roleRepository;

  @Override
  public Role getByName(String name) {
    return roleRepository.findByName(name)
        .orElseThrow(() -> new EntityNotFoundException("Role no encontrado"));
  }
}
