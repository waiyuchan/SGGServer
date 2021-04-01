package com.unconme.sgg.dao.mapper;

import com.unconme.sgg.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface LSATMapper extends Mapper<LSAT>{
	@Select("select * FROM lsat WHERE aid=#{aid}")
	@Results({@Result(property="lsatId", column="lsat_id", id=true), 
		@Result(property="aid", column="aid"), 
		@Result(property="score", column="score")})
	public LSAT selectByAid(@Param("aid") String aid);

}
