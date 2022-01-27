package com.manager.user.repository.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mst_group")
public class MstGroup {
  
  @Id
  @Column(name = "group_id")
  private Integer groupId;
  
  @Column(name = "group_name")
  private String groupName;
  
  /**
   * casecade khi thực hiên thay đổi entity này dẫn đến 1 thay đổi của entity khác (ví dụ  1-n)
   */
  @OneToMany(targetEntity = TblUser.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "group_id", referencedColumnName = "group_id")
  private List<TblUser> tblUsers = new ArrayList<TblUser>();

}
