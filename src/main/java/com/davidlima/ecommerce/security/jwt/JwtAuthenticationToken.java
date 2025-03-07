package com.davidlima.ecommerce.security.jwt;

import java.util.Collection;
import javax.security.auth.Subject;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * Description of JwtAuthenticationToken.
 *
 * @author David Lima
 */

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

  private final Object principal;

  public JwtAuthenticationToken(
      Object principal) {
    super(null);
    this.principal = principal;
    setAuthenticated(false);
  }

  public JwtAuthenticationToken(Object principal,
      Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    this.principal = principal;
    super.setAuthenticated(true);
  }

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return principal;
  }
}
