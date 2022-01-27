package com.manager.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.manager.user.common.filter.JwtFilter;
import com.manager.user.common.filter.UserNameAndPasswordAuthenticationRequestFilter;
import com.manager.user.common.util.JwtUtil;
import com.manager.user.service.impl.UserDetailServiceImpl;

@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  UserDetailServiceImpl applicationUserService;

  @Autowired
  JwtFilter jwtFilter;
  
  @Autowired
  JwtUtil jwtUtil;
  
  @Autowired
  JwtConfig jwtConfig;
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().addFilter(new UserNameAndPasswordAuthenticationRequestFilter(authenticationManager(), jwtUtil,jwtConfig))
        .addFilterAfter(jwtFilter, UserNameAndPasswordAuthenticationRequestFilter.class)
        .authorizeRequests()
        .antMatchers("/authenticate").permitAll().anyRequest().authenticated();
  }
  
  // quản lí user
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(applicationUserService).passwordEncoder(new BCryptPasswordEncoder());
  }
}
