package com.unconme.sgg.entity;

import com.unconme.sgg.entity.*;
import java.util.Date;
import javax.persistence.Id;
import org.springframework.lang.Nullable;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

//Data注解自动创建get set方法
@Data
//Table注解自动建表，参数为表名
@Table(name="user_applicant")
public class UserApplicant {
	@Id
	@Column(name="oid", type=MySqlTypeConstant.INT, isKey=true, isAutoIncrement=true)
	private Integer oid;
	
	@Column(name="aid", type=MySqlTypeConstant.VARCHAR, isNull=false)
	private String aid;
	
	@Column(name="uid", type=MySqlTypeConstant.INT)
	private Integer uid;
	
	private User user;
	private Applicant applicant;

}
