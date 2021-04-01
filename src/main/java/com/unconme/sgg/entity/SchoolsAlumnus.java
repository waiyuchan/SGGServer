package com.unconme.sgg.entity;

import javax.persistence.Id;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name="schools_alumnus")
public class SchoolsAlumnus {
	@Id
	@Column(name="s_a_id",type=MySqlTypeConstant.INT, isKey=true, isAutoIncrement=true)
    private Integer sAId;
	
	@Column(name="school_id",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String schoolId;
	
	@Column(name="alumnus_id",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String alumnusId;
	
	private School school;
	private Alumnus alumnus;

}
