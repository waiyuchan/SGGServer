package com.unconme.sgg.dao.mapper;

import com.unconme.sgg.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import tk.mybatis.mapper.common.Mapper;


public interface UserMapper extends Mapper<User>{
	@Select("SELECT * FROM user WHERE open_id=#{open_id}")
	@Results(id="userMap", value={@Result(property="uid", column="uid", id=true), 
		@Result(property="openId", column="open_id"), 
		@Result(property="nickname", column="nickname"), 
		@Result(property="email", column="email"), 
		@Result(property="phone", column="phone"), 
		@Result(property="avatar", column="avatar"), 
		@Result(property="country", column="country"), 
		@Result(property="city", column="city"), 
		@Result(property="collect", column="uid", 
		many=@Many(select="com.unconme.sgg.dao.mapper.CollectMapper.selectByCollectId",
				fetchType=FetchType.EAGER))})
	public User selectByOpenId(@Param("open_id") String openId);
	
	@Select("SELECT * FROM user WHERE uid=#{uid}")
	@ResultMap(value="userMap")
	public User selectByUid(@Param("uid") Integer uid);
}
