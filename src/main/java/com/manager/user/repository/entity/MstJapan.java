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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mst_japan")
public class MstJapan {

  @Id
  @Column(name = "code_level")
  private String codeLevel;
  @Column(name = "name_level")
  private String nameLevel;
  @OneToMany(mappedBy = "mstJapan", cascade = CascadeType.ALL)
  private List<TblDetailUserJapan> tblDetailUserJapans = new ArrayList<>();
  
}
