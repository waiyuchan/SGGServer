package com.unconme.sgg.dao.mapper;

import com.unconme.sgg.entity.*;
import tk.mybatis.mapper.common.Mapper;

public interface AlumnusMapper extends Mapper<Alumnus>{
//	@Select("SELECT * FROM alumnus WHERE school_id=#{school_id}")
//	@Results(id="AlumnusMap", value= {@Result(property="alumnusId", column="alumnus_id", id=true), 
//			@Result(property="schoolId", column="school_id"), 
//			@Result(property="introduction", column="introduction")})
//	public Alumnus selectBySchoolId(@Param("school_id") String schoolId);

}
