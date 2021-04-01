package com.unconme.sgg.dao.mapper;

import com.unconme.sgg.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.annotations.One;
import tk.mybatis.mapper.common.Mapper;

public interface UserApplicantMapper extends Mapper<UserApplicant>{
	@Select("select * from user_applicant where oid=#{oid}")
	@Results({@Result(property="oid", column="oid", id=true), 
		@Result(property="aid", column="aid"), 
		@Result(property="uid", column="uid"), 
		@Result(property="applicant", column="aid", 
		one=@One(select="com.unconme.sgg.dao.mapper.ApplicantMapper.selectByAid",
		fetchType=FetchType.EAGER)), 
		@Result(property="user", column="uid", 
		one=@One(select="com.unconme.sgg.dao.mapper.UserMapper.selectByUid",
		fetchType=FetchType.EAGER))})
	public UserApplicant selectByOid(@Param("oid") Integer aid);

}
