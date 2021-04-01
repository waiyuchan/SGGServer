package com.unconme.sgg.entity;

import com.unconme.sgg.entity.*;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name="gre")
public class GRE {
	@Id
	@Column(name="gre_id",type=MySqlTypeConstant.INT, isKey=true, isAutoIncrement=true)
    private Integer greId;
	
	@Column(name="aid",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String aid;
	
	@Column(name="q",type=MySqlTypeConstant.FLOAT, isNull=false)
    private float q;
	
	@Column(name="v",type=MySqlTypeConstant.FLOAT, isNull=false)
    private float v;
	
	@Column(name="aw",type=MySqlTypeConstant.FLOAT, isNull=false)
    private float aw;
	
	private List<GRESub> greSub;

}
