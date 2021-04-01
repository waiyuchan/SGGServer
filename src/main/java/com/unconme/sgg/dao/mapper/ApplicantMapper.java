package com.unconme.sgg.dao.mapper;

import com.unconme.sgg.entity.Applicant;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import tk.mybatis.mapper.common.Mapper;

public interface ApplicantMapper extends Mapper<Applicant>{
	@Select("SELECT * FROM applicant WHERE aid=#{aid}")
	@Results(id="applicantMap", value={@Result(property="aid", column="aid", id=true), 
		@Result(property="ugSchool", column="ug_school"), 
		@Result(property="ugMajor", column="ug_major"), 
		@Result(property="ugGpa", column="ug_gpa"), 
		@Result(property="ugNote", column="ug_note"), 
		@Result(property="city", column="city"), 
		@Result(property="masterInfo", column="aid", 
		one=@One(select="com.unconme.sgg.dao.mapper.MasterApplicantMapper.selectByPrimaryKey",
				fetchType=FetchType.EAGER)), 
		@Result(property="gmat", column="aid", 
		many=@Many(select="com.unconme.sgg.dao.mapper.GMATMapper.selectByAid",
				fetchType=FetchType.EAGER)), 
		@Result(property="gre", column="aid", 
		many=@Many(select="com.unconme.sgg.dao.mapper.GREMapper.selectByAid",
				fetchType=FetchType.EAGER)), 
		@Result(property="lsat", column="aid", 
		many=@Many(select="com.unconme.sgg.dao.mapper.LSATMapper.selectByAid",
				fetchType=FetchType.EAGER)), 
		@Result(property="ielts", column="aid", 
		many=@Many(select="com.unconme.sgg.dao.mapper.IELTSMapper.selectByAid",
				fetchType=FetchType.EAGER)), 
		@Result(property="toefl", column="aid", 
		many=@Many(select="com.unconme.sgg.dao.mapper.TOEFLMapper.selectByAid",
				fetchType=FetchType.EAGER)), 
		@Result(property="stanCase", column="aid", 
		many=@Many(select="com.unconme.sgg.dao.mapper.StanCaseMapper.selectByAid",
				fetchType=FetchType.EAGER))})
	public Applicant selectByAid(@Param("aid") String aid);

}
