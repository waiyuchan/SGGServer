package com.unconme.sgg.entity;

import javax.persistence.Id;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name="choose_school_record")
public class ChooseSchoolRecord {
	@Id
	@Column(name="record_id",type=MySqlTypeConstant.INT, isKey=true, isAutoIncrement=true)
    private Integer recordId;
	
	@Column(name="school_name", type=MySqlTypeConstant.VARCHAR, isNull=false)
	private String schoolName;
	
	@Column(name="open_id", type=MySqlTypeConstant.VARCHAR, isNull=false)
	private String openId;
	
	@Column(name="choose_date", type=MySqlTypeConstant.VARCHAR, isNull=false)
	private String chooseDate;
	
	@Column(name="school_level", type=MySqlTypeConstant.VARCHAR, isNull=false)
	private String schoolLevel;
}
