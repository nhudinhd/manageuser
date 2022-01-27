package com.manager.user.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tbl_user")
@Entity(name = "TblUser")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TblUser {

  @Id
  @Column(name = "user_id")
  private Integer userId;
  
  @Column(name = "group_id")
  private String group_id;
  
  @Column(name = "login_name")
  private String loginName;
  
  @Column(name = "password")
  private String password;
  
  private String fullName;
  
  private String fullNameKana;
  
  private String email;
  
  private String tel;
  
  private String birthday;
  
  private Integer rule;
  
  @OneToMany(mappedBy = "tblUser", cascade = CascadeType.ALL)
  private List<TblDetailUserJapan> tblDetailUserJapans = new ArrayList<>();
}
