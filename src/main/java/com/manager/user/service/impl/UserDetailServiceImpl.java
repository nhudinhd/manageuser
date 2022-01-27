package com.manager.user.service.impl;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.manager.user.repository.TblUserRepository;
import com.manager.user.repository.entity.TblUser;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

  @Autowired
  private TblUserRepository tblUserRepository;

  @Override
  public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
    TblUser tblUser =  tblUserRepository.findByLoginName(loginName);
    return new User(tblUser.getLoginName(),tblUser.getPassword() ,
        Collections.singletonList(new SimpleGrantedAuthority("ADMIN")));
  }
}
