package com.unconme.sgg.dao.mapper;

import com.unconme.sgg.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface GRESubMapper extends Mapper<GRESub>{
	@Select("SELECT * FROM gre_sub WHERE gre_id=#{gre_id}")
	@Results({@Result(property="greSubId", column="gre_sub_id"), 
		@Result(property="greId", column="gre_id"), 
		@Result(property="subject", column="subject"), 
		@Result(property="score", column="score")})
	public GRESub selectByGREId(@Param("gre_id") Integer greId);

}
