package com.unconme.sgg.entity;

import java.util.Date;

import javax.persistence.Id;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name="weibo_case")
public class WeiboCase {
	@Id
	@Column(name="case_id",type=MySqlTypeConstant.VARCHAR, isKey=true)
    private String caseId;
	
	@Column(name="case_date",type=MySqlTypeConstant.DATE, isNull=false)
    private Date caseDate;
	
	@Column(name="content",type=MySqlTypeConstant.TEXT, isNull=false)
    private String content;

}
