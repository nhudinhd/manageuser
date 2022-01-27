package com.manager.user.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.manager.user.repository.entity.TblUser;

@Repository
public interface TblUserRepository extends JpaRepository<TblUser,Integer> {
  TblUser findByLoginName(String loginName);
  
  void deleteByUserId(int userId);
  
  @Query("SELECT t FROM TblUser t LEFT JOIN t.tblDetailUserJapans d JOIN d.mstJapan m "
  		+ "WHERE t.loginName = ?1")
  Page<TblUser> findAll(String name, Pageable pageable);
}
