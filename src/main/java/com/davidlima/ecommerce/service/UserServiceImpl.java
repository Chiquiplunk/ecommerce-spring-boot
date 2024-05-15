package com.davidlima.ecommerce.service;

import com.davidlima.ecommerce.dto.UserDto;
import com.davidlima.ecommerce.entity.User;
import com.davidlima.ecommerce.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Description of UserServiceImpl.
 *
 * @author David Lima
 */

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

  @Override
  public void enableUser(User user) {
    user.setEnable(true);
    userRepository.save(user);
  }

  @Override
  public User findById(UUID id) {
    return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
  }

  private UserRepository userRepository;

  @Override
  public UserDto getById(UUID id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));

    UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setFirstName(user.getFirstName());
    userDto.setLastName(user.getLastName());
    userDto.setAddress(user.getAddress());
    userDto.setEmail(user.getEmail());
    userDto.setRoleName(user.getRole().getName());
    return userDto;
  }

  @Override
  public boolean existByEmail(String email) {
    return userRepository.existsByEmail(email);
  }

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }
}
