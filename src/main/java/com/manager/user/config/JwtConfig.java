package com.manager.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ConfigurationProperties(prefix = "application.jwt")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class JwtConfig {

    private String secretKey;
    private String tokenPrefix;
    private Integer tokenExpirationAfterDays;
    
    public String getAuthorizationHeader() {
      return org.springframework.http.HttpHeaders.AUTHORIZATION;
  }

}