package com.unconme.sgg.dao.mapper;

import com.unconme.sgg.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FavoriteMapper extends Mapper<Favorite>{
	@Select("SELECT * FROM collect WHERE collect_id=#{collect_id}")
	@Results(id="CollectMap", value={@Result(property="collectId", column="collect_id", id=true), 
		@Result(property="caseId", column="case_id"), 
		@Result(property="uid", column="uid"), 
		@Result(property="caseType", column="case_type"), 
		@Result(property="collectType", column="collect_type"), 
		@Result(property="schoolId", column="school_id"), 
		@Result(property="stanCase", column="case_id", 
		one=@One(select="com.unconme.sgg.dao.mapper.StanCaseMapper.selectByAid",
				fetchType=FetchType.EAGER)), 
		@Result(property="weiboCase", column="case_id", 
		one=@One(select="com.unconme.sgg.dao.mapper.WeiboCaseMapper.selectByPrimaryKey",
				fetchType=FetchType.EAGER)), 
		@Result(property="user", column="uid", 
		one=@One(select="com.unconme.sgg.dao.Mapper.UserMapper.selectByUid", 
				fetchType=FetchType.EAGER)), 
		@Result(property="school", column="school_id", 
		one=@One(select="com.unconme.sgg.dao.Mapper.SchoolMapper.selectByPrimaryKey", 
				fetchType=FetchType.EAGER)), })
	public Favorite selectByCollectId(@Param("collect_id") String collectId);
	
	@Select("SELECT * FROM collect WHERE uid=#{user_id}")
	@ResultMap(value = { "CollectMap" })
	public List<Favorite> selectByUserId(@Param("user_id") Integer userId);
}
