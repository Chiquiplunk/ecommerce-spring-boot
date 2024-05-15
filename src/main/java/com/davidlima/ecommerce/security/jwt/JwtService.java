package com.davidlima.ecommerce.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.davidlima.ecommerce.entity.User;
import com.davidlima.ecommerce.service.UserService;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import lombok.AllArgsConstructor;
import org.aspectj.apache.bcel.generic.MULTIANEWARRAY;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Description of JwtService.
 *
 * @author David Lima
 */

@Service

public class JwtService {


  private final UserService userService;

  @Value("${spring.jwt.secret-key}")
  private String secretKey;
  @Value("${spring.jwt.expiration-time}")
  private long expirationTime;

  public JwtService(UserService userService) {
    this.userService = userService;
  }

  public String create(User user){
    return JWT.create()
        .withSubject(user.getId().toString())
        .withIssuedAt(new Date())
        .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(expirationTime)))
        .withClaim("role", user.getRole().getName())
        .sign(Algorithm.HMAC256(secretKey));
  }

  public User decodeToken(String token){

    JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
    DecodedJWT decodedJWT = verifier.verify(token);
    String userId = decodedJWT.getSubject();
    return userService.findById(UUID.fromString(userId));
  }
}
