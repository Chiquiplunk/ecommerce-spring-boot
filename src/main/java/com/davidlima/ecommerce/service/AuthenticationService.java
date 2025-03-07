package com.davidlima.ecommerce.service;

import com.davidlima.ecommerce.dto.AuthenticationRequest;
import com.davidlima.ecommerce.dto.AuthenticationResponse;
import com.davidlima.ecommerce.entity.User;
import com.davidlima.ecommerce.security.jwt.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Description of AuthenticationService.
 *
 * @author David Lima
 */

@Service
@AllArgsConstructor
public class AuthenticationService {

  private AuthenticationManager authenticationManager;
  private JwtService jwtService;

  public AuthenticationResponse authenticate(AuthenticationRequest request){

    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
    Authentication authResponse = authenticationManager.authenticate(auth);

    User user = (User) authResponse.getPrincipal();
    String accessToken = jwtService.create(user);

    return AuthenticationResponse.builder()
        .accessToken(accessToken)
        .build();


  }
}
