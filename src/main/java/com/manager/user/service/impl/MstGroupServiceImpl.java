package com.manager.user.service.impl;

import javax.transaction.Transactional;

import org.aspectj.internal.lang.annotation.ajcDeclareEoW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.user.repository.MstGroupRepository;
import com.manager.user.service.MstGroupService;

@Service
public class MstGroupServiceImpl implements MstGroupService {

	@Autowired
	private MstGroupRepository mstGroupRepository;
	
	@Transactional
	@Override
	public void deleteByGroupId(Integer groupId) {
		mstGroupRepository.deleteByGroupId(groupId);
		
	}

}
