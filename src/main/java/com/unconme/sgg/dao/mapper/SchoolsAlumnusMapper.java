package com.unconme.sgg.dao.mapper;

import com.unconme.sgg.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.annotations.One;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SchoolsAlumnusMapper extends Mapper<SchoolsAlumnus>{
	@Select("SELECT * FROM schools_alumnus WHERE s_a_id=#{s_a_id}")
	@Results(id="SchoolsAlumnusMap", value={@Result(property="sAId", column="s_a_id", id=true),
			@Result(property="schoolId", column="school_id"), 
			@Result(property="alumnusId", column="alumnus_id"), 
			@Result(property="school", column="school_id", 
			one=@One(select="com.unconme.sgg.dao.mapper.SchoolMapper.selectBySchoolId",
					fetchType=FetchType.EAGER)), 
			@Result(property="alumnus", column="alumnus_id", 
			one=@One(select="com.unconme.sgg.dao.mapper.AlumnusMapper.selectByPrimaryKey",
					fetchType=FetchType.EAGER))})
	public SchoolsAlumnus selectBySAId(@Param("s_a_id") Integer sAId);

	@Select("SELECT * FROM schools_alumnus WHERE school_id=#{school_id}")
	@ResultMap(value={"SchoolsAlumnusMap"})
	public List<SchoolsAlumnus> selectBySchoolId(@Param("school_id") String schoolId);

}
