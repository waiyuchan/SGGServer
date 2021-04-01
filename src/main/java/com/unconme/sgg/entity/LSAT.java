package com.unconme.sgg.entity;

import java.util.Date;

import javax.persistence.Id;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name="lsat")
public class LSAT {
	@Id
	@Column(name="lsat_id",type=MySqlTypeConstant.INT, isKey=true)
    private Integer lsatId;
	
	@Column(name="aid",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String aid;
	
	@Column(name="score",type=MySqlTypeConstant.FLOAT, isNull=false)
    private float score;

}
