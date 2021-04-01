package com.unconme.sgg.dao.mapper;

import com.unconme.sgg.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface GMATMapper extends Mapper<GMAT>{
	// ����aid��ѯ
	@Select("select * FROM gmat WHERE aid=#{aid}")
	@Results({@Result(property="gmatId", column="gmat_id", id=true), 
		@Result(property="aid", column="aid"), 
		@Result(property="q", column="q"), 
		@Result(property="v", column="v")})
	public GMAT selectByAid(@Param("aid") String aid);

}
