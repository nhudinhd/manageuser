package com.manager.user.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.manager.user.repository.TblUserRepository;
import com.manager.user.service.TblUserService;

@Service
public class TblUserServiceImpl implements TblUserService {

	@Autowired
	TblUserRepository tblUserRepository;
	@Override
	@Transactional
	public void deleteByUserId(int userId) {
		Page a = tblUserRepository.findAll("an", PageRequest.of(0, 5));
		System.out.println(a.getSize());
	}

}
