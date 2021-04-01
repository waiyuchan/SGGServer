package com.unconme.sgg.entity;

import java.util.Date;

import javax.persistence.Id;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name="gre_sub")
public class GRESub {
	@Id
	@Column(name="gre_sub_id",type=MySqlTypeConstant.INT, isKey=true)
    private Integer greSubId;
	
	@Column(name="gre_id",type=MySqlTypeConstant.INT, isNull=false)
    private Integer greId;
	
	@Column(name="subject",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String subject;
	
	@Column(name="score",type=MySqlTypeConstant.FLOAT, isNull=false)
    private float score;

}
