package com.unconme.sgg.entity;

import javax.persistence.Id;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name="school_rank")
public class SchoolRank {
	@Id
	@Column(name="school_id",type=MySqlTypeConstant.VARCHAR, isKey=true)
    private String schoolId;
	
	@Column(name="qs_rank",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String qsRank;
	
	@Column(name="times_rank",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String timesRank;
	
	@Column(name="shangjiao_rank",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String shangjiaoRank;
}
