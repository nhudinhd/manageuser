package com.manager.user.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_detail_user_japan")
public class TblDetailUserJapan {
  @Id
  @Column(name = "detail_user_japan_id")
  private Integer detailUserJapanId;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private TblUser tblUser;
  @ManyToOne
  @JoinColumn(name = "code_level")
  private MstJapan mstJapan;
  @Column(name = "start_date")
  private String startDate;
  @Column(name = "end_date")
  private String endDate;
  @Column(name = "total")
  private String total;
}
