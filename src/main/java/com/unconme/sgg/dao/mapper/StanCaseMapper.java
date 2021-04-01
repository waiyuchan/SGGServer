package com.unconme.sgg.dao.mapper;

import com.unconme.sgg.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface StanCaseMapper extends Mapper<StanCase>{
	@Select("SELECT * FROM stan_case WHERE aid=#{aid}")
	@Results(id="CaseMap", value={@Result(property="caseId", column="case_id", id=true),
			@Result(property="resultDate", column="result_date"),
			@Result(property="aid", column="aid"),
			@Result(property="schoolId", column="school_id"),
			@Result(property="degree", column="degree"),
			@Result(property="major", column="major"),
			@Result(property="result", column="result"),
			@Result(property="term", column="term"),
			@Result(property="school", column="school_id",
					one=@One(select="com.unconme.sgg.dao.mapper.SchoolMapper.selectByPrimaryKey",
							fetchType=FetchType.EAGER)),
			@Result(property="applicant", column="aid",
					one=@One(select="com.unconme.sgg.dao.mapper.ApplicantMapper.selectByAid",
							fetchType=FetchType.EAGER))})
	public StanCase selectByAid(@Param("aid") String aid);

	@Select("SELECT * FROM stan_case")
	@ResultMap(value={"CaseMap"})
	public List<StanCase> selectAllCases();

	@Select("SELECT * FROM stan_case WHERE school_id=#{school}")
	@ResultMap(value={"CaseMap"})
	public List<StanCase> selectBySchoolId(@Param("school") String schoolId);

	@Select("SELECT * FROM stan_case WHERE school_id=#{schoolId} and major=#{majorName}")
	@ResultMap(value={"CaseMap"})
	public List<StanCase> selectBySchoolIdAndMajor(@Param("schoolId") String schoolId, @Param("majorName") String majorName);

	@Select("SELECT * FROM stan_case WHERE case_id=#{caseId]")
	@ResultMap(value={"CaseMap"})
	public StanCase selectByCaseId(@Param("caseId") String caseId);

	@Select("<script>"
			+ "SELECT * FROM stan_case WHERE major in "
			+ "<foreach item='major' collection='majorList' open='(' separator=',' close=')'>"
			+ "#{major}"
			+ "</foreach>"
			+ "</script>")
	@ResultMap(value={"CaseMap"})
	public List<StanCase> selectByMajorId(@Param("majorList") List<String> majorIdList);

	@Select("SELECT * FROM stan_case WHERE major=#{majorId}")
	@ResultMap(value={"CaseMap"})
	public List<StanCase> selectByMajor(@Param("majorId") String majorId);

}
