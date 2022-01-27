package com.manager.user.common.util;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.manager.user.config.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {
  
  @Autowired
  private JwtConfig jwtConfig;

  /**
   * lấy tên người dùng từ token
   * 
   * @param token
   */
  public String extractUserName(String token) {
    return extractClaim(token, Claims::getSubject);
  }
  
  public Date extractExpiration (String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  public <T> T extractClaim(String token, Function<Claims, T> cliamsResolve) {
    Claims claims = extractAllClaims(token);
    return cliamsResolve.apply(claims);
  }

  private Claims extractAllClaims(String token) {
    return Jwts.parser().setSigningKey(jwtConfig.getSecretKey()).parseClaimsJws(token).getBody();
  }

  public Boolean isTokenExpried(String token) {
    return extractExpiration(token).before(new Date());
  }

  public String generateToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>();
    return createToken(claims, userDetails.getUsername());
  }

  public String createToken(Map<String, Object> claims, String subject) {
    return Jwts.builder().setClaims(claims).setSubject(subject)
        .setIssuedAt(new Date())
        .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfig.getTokenExpirationAfterDays())))
        .signWith(SignatureAlgorithm.HS256, jwtConfig.getSecretKey()).compact();
  }

  public Boolean valdiateToken(String token, UserDetails userDetails) {
    String userName = extractUserName(token);
    return userName.equals(userDetails.getUsername())&& !isTokenExpried(token);
  }
}
