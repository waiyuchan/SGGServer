package com.unconme.sgg.dao.mapper;

import com.unconme.sgg.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.annotations.Many;
import tk.mybatis.mapper.common.Mapper;

public interface GREMapper extends Mapper<GRE>{
	@Select("SELECT * FROM gre WHERE gre_id=#{gre_id}")
	@Results(id="GREMap", value= {@Result(property="greId", column="gre_id"), 
			@Result(property="aid", column="aid"), 
			@Result(property="q", column="q"), 
			@Result(property="v", column="v"), 
			@Result(property="aw", column="aw"), 
			@Result(property="greSub", column="gre_id", 
			many=@Many(select="com.unconme.sgg.dao.mapper.GRESubMapper.selectByGREId",
					fetchType=FetchType.EAGER))})
	public GRE selectByGREId(@Param("gre_id") Integer greId);
	
	@Select("select * FROM gre WHERE aid=#{aid}")
	@ResultMap(value="GREMap")
	public GRE selectByAid(@Param("aid") String aid);

}
