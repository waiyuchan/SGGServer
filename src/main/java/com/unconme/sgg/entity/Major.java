package com.unconme.sgg.entity;

import javax.persistence.Id;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name="major")
public class Major {
	@Id
	@Column(name="major_id",type=MySqlTypeConstant.VARCHAR, isKey=true)
    private String majorId;
	
	@Column(name="school_id",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String schoolId;
	
	@Column(name="rank",type=MySqlTypeConstant.VARCHAR)
    private String rank;
	
	@Column(name="major_name_ch",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String majorNameCh;
	
	@Column(name="major_name_en",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String majorNameEn;
	
	// 学时
	@Column(name="academic_hours",type=MySqlTypeConstant.VARCHAR)
    private String academicHours;
	
	// 课程数
	@Column(name="course_num",type=MySqlTypeConstant.VARCHAR)
    private String courseNum;
	
	@Column(name="language_con",type=MySqlTypeConstant.VARCHAR)
    private String languageCon;
	
	// 学制
	@Column(name="schooling_length",type=MySqlTypeConstant.VARCHAR)
    private String SchoolingLength;
	
	// 学制
	@Column(name="apply_type",type=MySqlTypeConstant.VARCHAR)
	private String applyType;
	
	// 学费
	@Column(name="tution_fee",type=MySqlTypeConstant.VARCHAR)
    private String tutionFee;
	
	@Column(name="introduction",type=MySqlTypeConstant.VARCHAR)
    private String introduction;
}
