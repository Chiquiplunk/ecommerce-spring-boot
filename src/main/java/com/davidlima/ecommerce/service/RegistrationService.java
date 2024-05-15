package com.davidlima.ecommerce.service;

import com.davidlima.ecommerce.dto.EmailNotification;
import com.davidlima.ecommerce.dto.UserDto;
import com.davidlima.ecommerce.entity.ConfirmationToken;
import com.davidlima.ecommerce.entity.Role;
import com.davidlima.ecommerce.entity.User;
import com.davidlima.ecommerce.exception.EmailAlreadyTaken;
import com.davidlima.ecommerce.utility.TemplateGenerator;
import com.davidlima.ecommerce.utility.UrlGenerator;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Description of RegistrationService.
 *
 * @author David Lima
 */

@Service
@AllArgsConstructor
public class RegistrationService {

  private UserService userService;
  private ConfirmationTokenService confirmationTokenService;
  private EmailService emailService;
  private PasswordEncoder passwordEncoder;
  private RoleService roleService;

  public String register(UserDto userDto){
    boolean existsEmail = userService.existByEmail(userDto.getEmail());
    if (existsEmail){
      throw new EmailAlreadyTaken(userDto.getEmail());
    }

    User user = new User();
    user.setFirstName(userDto.getFirstName());
    user.setLastName(userDto.getLastName());
    user.setAddress(userDto.getAddress());
    user.setEmail(userDto.getEmail());
    String encryptedPassword = passwordEncoder.encode(userDto.getPassword());
    user.setPassword(encryptedPassword);

    Role defaultRole = roleService.getByName("USER");
    user.setRole(defaultRole);

    User userSaved = userService.save(user);

    String token = UUID.randomUUID().toString();

    confirmationTokenService.save(new ConfirmationToken(
        token,
        LocalDateTime.now().plusMinutes(15),
        userSaved
    ));

    String url = UrlGenerator.create("/auth/confirm","token",token);
    String template = TemplateGenerator.generateTemplateConfirmationToken(userSaved.getFirstName(),url);

    EmailNotification email = EmailNotification.builder()
        .to(userSaved.getEmail())
        .subject("Account Confirmation")
        .body(template)
        .hasTemplate(true)
        .build();

    emailService.send(email);

    return "User registrado con éxito, id: " + userSaved.getId();
  }

  public String confirm(String token){

    ConfirmationToken confirmationToken = confirmationTokenService.getByToken(token);
    if (confirmationToken.getConfirmedAt() != null){
      throw new RuntimeException("Token está confirmado");
    }
    if (confirmationToken.getExpiresAt().isBefore(LocalDateTime.now())){
      throw new RuntimeException("Token expirado");
    }
    userService.enableUser(confirmationToken.getUser());
    confirmationTokenService.setConfirmedAt(confirmationToken);

    return "Cuenta confirmada exitosamente";
  }
}
