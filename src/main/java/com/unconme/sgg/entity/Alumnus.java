package com.unconme.sgg.entity;

import javax.persistence.Id;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data		//@Data娉ㄨВ���ㄥ��寤�get(),set()绛��规�
@Table(name="alumnus")
public class Alumnus {
	@Id
	@Column(name="alumnus_id",type=MySqlTypeConstant.VARCHAR, isKey=true)
    private String alumnusId;
	
	@Column(name="alumnus_name",type=MySqlTypeConstant.VARCHAR)
    private String alumnusName;
	
	@Column(name="introduction",type=MySqlTypeConstant.VARCHAR)
    private String introduction;

}
