package com.davidlima.ecommerce.security.jwt;

import com.davidlima.ecommerce.entity.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

/**
 * Description of JwtAuthenticationProvider.
 *
 * @author David Lima
 */

@Service
public class JwtAuthenticationProvider implements AuthenticationProvider {

  private final JwtService jwtService;

  public JwtAuthenticationProvider(JwtService jwtService) {
    this.jwtService = jwtService;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    JwtAuthenticationToken auth = (JwtAuthenticationToken) authentication;
    String accessToken = (String) auth.getPrincipal();
    User user = jwtService.decodeToken(accessToken);


    return new JwtAuthenticationToken(user, user.getAuthorities());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return JwtAuthenticationToken.class.isAssignableFrom(authentication);
  }
}
