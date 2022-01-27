package com.manager.user.web.rest;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import com.manager.user.common.util.JwtUtil;
import com.manager.user.repository.MstGroupRepository;
import com.manager.user.repository.TblUserRepository;
import com.manager.user.repository.entity.MstGroup;
import com.manager.user.service.MstGroupService;
import com.manager.user.service.TblUserService;
import com.manager.user.service.impl.UserDetailServiceImpl;

@RestController
public class TblUserResource {
	@Autowired
	UserDetailServiceImpl userServiceImpl;
	@Autowired
	JwtUtil jwtUtil;
	@Autowired
	TblUserService tblUserService;
	@Autowired
	MstGroupService mstGroupService;
	@Autowired
	TblUserRepository tblUserRepository;
//
//  @PostMapping(path = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE,
//      produces = MediaType.APPLICATION_JSON_VALUE)
//  public ResponseEntity<AuthenticationResponse> createToken(
//      @RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//    try {
//      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//          authenticationRequest.getUserName(), authenticationRequest.getPassowrd()));
//    } catch (BadCredentialsException e) {
//      System.out.println("exception roi");
//    }
//    System.out.println(authenticationRequest.getUserName()+" "+authenticationRequest.getPassowrd());
//
//    UserDetails userDetails =
//        userServiceImpl.loadUserByUsername(authenticationRequest.getUserName());
//    String jwt = jwtUtil.generateToken(userDetails);
//    return ResponseEntity.ok(new AuthenticationResponse(jwt));
//  }

	@PostMapping(path = "/login")
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("haha");
	}

	@PostMapping(path = "/check")
	public ResponseEntity<String> check() {
		mstGroupService.deleteByGroupId(1);
		return ResponseEntity.ok("check");
	}
	
	@PostMapping(path = "/delete")
	public ResponseEntity<String> delete() {
		tblUserService.deleteByUserId(0);
		return  ResponseEntity.ok("check");
	}
}
