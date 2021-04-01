package com.unconme.sgg.dao.mapper;

import com.unconme.sgg.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MajorMapper extends Mapper<Major>{
	@Select("SELECT * FROM major WHERE school_id=#{school_id}")
	@Results(id="MajorMap", value= {@Result(property="majorId", column="major_id", id=true), 
			@Result(property="schoolId", column="school_id"), 
			@Result(property="rank", column="rank"), 
			@Result(property="majorNameCh", column="major_name_ch"), 
			@Result(property="majorNameEn", column="major_name_en"), 
			@Result(property="academicHours", column="academic_hours"), 
			@Result(property="courseNum", column="course_num"), 
			@Result(property="languageCon", column="language_con"), 
			@Result(property="introduction", column="introduction"), 
			@Result(property="tutionFee", column="tution_fee"), 
			@Result(property="applyType", column="apply_type"),
			@Result(property="SchoolingLength", column="schooling_length")})
	public List<Major> selectBySchoolId(@Param("school_id") String schoolId);
	
	// 根据学校中文名和专业英文名查询
	@Select("SELECT rank, major_name_en, academic_hours, course_num, tution_fee FROM major WHERE school_name_ch=#{school_name_ch} AND major_name_en=#{major_name_en}")
	@Results({@Result(property="rank", column="rank"), 
		@Result(property="majorNameEn", column="major_name_en"), 
		@Result(property="academicHours", column="academic_hours"), 
		@Result(property="courseNum", column="course_num"), 
		@Result(property="tutionFee", column="tution_fee"), })
	public Major selectBySchoolAndMajorName(@Param("school_name_ch") String schoolNameCh, @Param("major_name_en") String majorNameEn);


	@Select("SELECT * FROM major WHERE school_id=#{school_id} limit 1")
	@ResultMap(value = {"MajorMap"})
	public Major selectMajorBySchoolId(@Param("school_id") String schoolId);

	@Select("SELECT * FROM major WHERE school_id=#{school_id} limit 5")
	@ResultMap(value = {"MajorMap"})
	public List<Major> selectPopularMajors(@Param("school_id") String schoolId);

	@Select("SELECT * FROM major WHERE major_id=#{major_id}")
	@ResultMap(value = {"MajorMap"})
	public Major selectByMajorId(@Param("major_id") String majorId);

	@Select("SELECT * FROM major WHERE school_id=#{school_id} AND major_name_ch=#{majorCnName}")
	@ResultMap(value = {"MajorMap"})
	public Major selectBySchoolIdAndMajorCnName(@Param("school_id") String schoolId,
												@Param("majorCnName") String majorCnName);

	@Select("SELECT major_id FROM major WHERE major_name_ch=#{majorCnName}")
	@Result(property="majorId", column="major_id", id=true)
	public List<String> selectMajorIdByMajorName(@Param("majorCnName") String majorCnName);


}
