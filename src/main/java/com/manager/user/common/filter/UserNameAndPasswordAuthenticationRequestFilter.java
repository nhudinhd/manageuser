package com.manager.user.common.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manager.user.common.util.JwtUtil;
import com.manager.user.config.JwtConfig;
import com.manager.user.web.rest.request.AuthenticationRequest;

public class UserNameAndPasswordAuthenticationRequestFilter
    extends UsernamePasswordAuthenticationFilter {  
  
  private JwtConfig jwtConfig;
  
  private AuthenticationManager authenticationManager;
  
  private JwtUtil jwtUtil;
  
  public UserNameAndPasswordAuthenticationRequestFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil, JwtConfig jwtConfig) {
    this.authenticationManager = authenticationManager;
    this.jwtUtil = jwtUtil;
    this.jwtConfig = jwtConfig;
  }
  
  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
      HttpServletResponse response) throws AuthenticationException {
    try {

      // đọc user name và password từ request
      AuthenticationRequest authenticationRequest =
          new ObjectMapper().readValue(request.getInputStream(), AuthenticationRequest.class);
      // xác thực user name và password có đúng hay không(authentication manager gửi đối tượng
      // UsernamePasswordAuthenticationToken đến AuthenticationProvider UserService validate giá trị
      // credentail
      Authentication authenticate =
          authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
              authenticationRequest.getUserName(), authenticationRequest.getPassword()));
      return authenticate;
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
  }

  /**
   * thực hiện khi xác thực user name và password thành công
   * @see org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter#successfulAuthentication(javax.servlet.http.HttpServletRequest,
   *      javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain,
   *      org.springframework.security.core.Authentication)
   */
  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain, Authentication authResult) throws IOException, ServletException {
    Map<String, Object> claims = new HashMap<>();
    claims.put("authorities", authResult.getAuthorities());
    String jwt = jwtUtil.createToken(claims, authResult.getName());
    response.addHeader(jwtConfig.getAuthorizationHeader(), jwtConfig.getTokenPrefix()+jwt);
  } 



}
