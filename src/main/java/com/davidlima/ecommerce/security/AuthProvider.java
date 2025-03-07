package com.davidlima.ecommerce.security;

import com.davidlima.ecommerce.security.jwt.JwtAuthenticationProvider;
import com.davidlima.ecommerce.security.jwt.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Description of AuthProvider.
 *
 * @author David Lima
 */

@Configuration
@AllArgsConstructor
public class AuthProvider {

  private UserDetailsService userDetailsService;
  private JwtService jwtService;

  @Bean
  public AuthenticationManager authenticationManager(){
    return new ProviderManager(daoAuthenticationProvider(), jwtAuthenticationProvider());
  }

  @Bean
  public DaoAuthenticationProvider daoAuthenticationProvider(){
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(passwordEncoder());
    provider.setUserDetailsService(userDetailsService);
    return provider;
  }

  @Bean
  public JwtAuthenticationProvider jwtAuthenticationProvider(){
    return new JwtAuthenticationProvider(jwtService);
  }

  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
}
