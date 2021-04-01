package com.unconme.sgg.entity;

import javax.persistence.Id;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name="toefl")
public class TOEFL {
	@Id
	@Column(name="toefl_id",type=MySqlTypeConstant.INT, isKey=true, isAutoIncrement=true)
    private Integer toeflId;
	
	@Column(name="aid",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String aid;
	
	@Column(name="r",type=MySqlTypeConstant.FLOAT, isNull=false)
    private float r;
	
	@Column(name="s",type=MySqlTypeConstant.FLOAT, isNull=false)
    private float s;
	
	@Column(name="w",type=MySqlTypeConstant.FLOAT, isNull=false)
    private float w;
	
	@Column(name="l",type=MySqlTypeConstant.FLOAT, isNull=false)
    private float l;

}
