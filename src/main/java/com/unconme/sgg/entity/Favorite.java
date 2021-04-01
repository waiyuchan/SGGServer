package com.unconme.sgg.entity;

import javax.persistence.Id;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name="collect")
public class Favorite {
	@Id
	@Column(name="collect_id",type=MySqlTypeConstant.VARCHAR, isKey=true)
    private String collectId;
	
	@Column(name="case_id",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String caseId;
	
	@Column(name="school_id",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String schoolId;
	
	@Column(name="uid",type=MySqlTypeConstant.INT, isNull=false)
    private Integer uid;
	
	// 收藏的类型，取值：school, major, case, gpa, choice
	@Column(name="collect_type",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String collectType;
	
	//weibo:0;standard:1
	@Column(name="case_type",type=MySqlTypeConstant.INT, isNull=false)
    private int caseType;
	
	private StanCase stanCase;
	private WeiboCase weiboCase;
	private User user;
	private School school;
	private Major major;

}
