package com.manager.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.manager.user.repository.entity.MstGroup;

public interface MstGroupRepository  extends JpaRepository<MstGroup, Integer>{

  void deleteByGroupId(Integer groupId);
}
