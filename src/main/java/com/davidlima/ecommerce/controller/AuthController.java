package com.davidlima.ecommerce.controller;

import com.davidlima.ecommerce.dto.AuthenticationRequest;
import com.davidlima.ecommerce.dto.AuthenticationResponse;
import com.davidlima.ecommerce.dto.EmailNotification;
import com.davidlima.ecommerce.dto.UserDto;
import com.davidlima.ecommerce.service.AuthenticationService;
import com.davidlima.ecommerce.service.EmailService;
import com.davidlima.ecommerce.service.RegistrationService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description of AuthController.
 *
 * @author David Lima
 */

@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {

  private RegistrationService registrationService;
  private EmailService emailService;
  private AuthenticationService authenticationService;

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody UserDto userDto){
    String message =  registrationService.register(userDto);
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(message);
  }

  @Hidden
  @PostMapping("/email")
  public String sendEmail(){
    EmailNotification email = EmailNotification.builder()
        .to("gerson2050@hotmail.com")
        .subject("TEST")
        .body("FEA FEA FEA FEA FEA FEA FEA")
        .hasTemplate(false)
        .build();

    EmailNotification email2 = EmailNotification.builder()
        .to("gerson2050@hotmail.com")
        .subject("TEST CON TEMPLATE")
        .body("<h1>FEA FEA FEA FEA FEA FEA FEA</h1>")
        .hasTemplate(true)
        .build();

    emailService.send(email);
    emailService.send(email2);

    return "mensaje enviado correctamente";
  }

  @GetMapping("/confirm")
  public ResponseEntity<String> confirm(@RequestParam String token){
    String message = registrationService.confirm(token);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(message);
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> authenticate (@RequestBody @Valid AuthenticationRequest request){
    AuthenticationResponse response = authenticationService.authenticate(request);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(response);
  }

}
