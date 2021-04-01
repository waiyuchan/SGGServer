package com.unconme.sgg.dao.mapper;

import com.unconme.sgg.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface TOEFLMapper extends Mapper<TOEFL>{
	@Select("select * FROM toefl WHERE aid=#{aid}")
	@Results({@Result(property="toeflId", column="toefl_id", id=true), 
		@Result(property="aid", column="aid"), 
		@Result(property="r", column="r"), 
		@Result(property="s", column="s"), 
		@Result(property="w", column="w"), 
		@Result(property="l", column="l")})
	public TOEFL selectByAid(@Param("aid") String aid);

}
