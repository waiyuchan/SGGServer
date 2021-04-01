package com.unconme.sgg.entity;

import java.util.Date;

import javax.persistence.Id;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name="gmat")
public class GMAT {
	@Id
	@Column(name="gmat_id",type=MySqlTypeConstant.INT, isKey=true, isAutoIncrement=true)
    private Integer gmatId;
	
	@Column(name="aid",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String aid;
	
	@Column(name="q",type=MySqlTypeConstant.FLOAT, isNull=false)
    private float q;
	
	@Column(name="v",type=MySqlTypeConstant.FLOAT, isNull=false)
    private float v;

}
