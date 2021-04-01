package com.unconme.sgg.entity;

import java.util.Date;

import javax.persistence.Id;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Table(name="master_applicant")
public class MasterApplicant{
	@Id
	@Column(name="aid",type=MySqlTypeConstant.VARCHAR, isKey=true)
    private String aid;
	
	@Column(name="pg_school",type=MySqlTypeConstant.VARCHAR)
    private String pgSchool;
	
	@Column(name="pg_major",type=MySqlTypeConstant.VARCHAR)
    private String pgMajor;
	
	@Column(name="pg_gpa",type=MySqlTypeConstant.FLOAT)
    private float pgGpa;

}
