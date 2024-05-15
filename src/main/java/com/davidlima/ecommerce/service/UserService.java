package com.davidlima.ecommerce.service;

import com.davidlima.ecommerce.dto.UserDto;
import com.davidlima.ecommerce.entity.User;
import java.util.UUID;

/**
 * Description of UserService.
 *
 * @author David Lima
 */

public interface UserService {

  UserDto getById(UUID id);

  boolean existByEmail(String email);

  User save(User user);

  void enableUser(User user);

  User findById(UUID id);

}
