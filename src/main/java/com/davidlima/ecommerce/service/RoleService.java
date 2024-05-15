package com.davidlima.ecommerce.service;

import com.davidlima.ecommerce.entity.Role;

/**
 * Description of RoleService.
 *
 * @author David Lima
 */

public interface RoleService {

  Role getByName(String name);
}
