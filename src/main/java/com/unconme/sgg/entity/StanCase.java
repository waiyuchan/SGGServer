package com.unconme.sgg.entity;

import javax.persistence.Id;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name="stan_case")	//standard case
public class StanCase {
	@Id
	@Column(name="case_id",type=MySqlTypeConstant.VARCHAR, isKey=true)
    private String caseId;
	
	@Column(name="result_date",type=MySqlTypeConstant.VARCHAR)
    private String resultDate;
	
	@Column(name="aid",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String aid;
	
	@Column(name="school_id",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String schoolId;
	
	@Column(name="degree",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String degree;
	
	@Column(name="major",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String major;
	
	//result=0 means fail; result=1 means success 
	@Column(name="result",type=MySqlTypeConstant.INT, isNull=false)
    private int result;
	
	//Spring:0; Fall:1
	@Column(name="term",type=MySqlTypeConstant.INT, isNull=false)
    private int term;
	
	private School school;
	private Applicant applicant;
}
