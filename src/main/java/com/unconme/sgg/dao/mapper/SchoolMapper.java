package com.unconme.sgg.dao.mapper;

import com.unconme.sgg.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SchoolMapper extends Mapper<School>{
	@Select("SELECT * FROM school WHERE school_id=#{school_id}")
	@Results(id="SchoolMap", value={@Result(property="schoolId", column="school_id", id=true), 
			@Result(property="cityId", column="city_id"), 
			@Result(property="chName", column="ch_name"), 
			@Result(property="enName", column="en_name"), 
			@Result(property="address", column="address"), 
			@Result(property="phone", column="phone"), 
			@Result(property="photoUrl", column="photo_url"), 
			@Result(property="url", column="url"), 
			@Result(property="applyMaterial", column="apply_material"), 
			@Result(property="email", column="email"), 
			@Result(property="openDate", column="open_date"), 
			@Result(property="days", column="days"), 
			@Result(property="requiredIelts", column="required_ielts"), 
			@Result(property="rejectRate", column="reject_rate"), 
			@Result(property="averageOfferSpeed", column="average_offer_speed"), 
			@Result(property="environment", column="environment"), 
			@Result(property="selectedReason", column="selected_reason"), 
			@Result(property="dorm", column="dorm"), 
			@Result(property="location", column="location"), 
			@Result(property="history", column="history"), 
			@Result(property="tuitionFee", column="tuition_fee"), 
			@Result(property="bookFee", column="book_fee"), 
			@Result(property="applyFee", column="apply_fee"), 
			@Result(property="hotelFee", column="hotel_fee"), 
			@Result(property="lifeFee", column="life_fee"), 
			@Result(property="employerRating", column="employer_rating"), 
			@Result(property="paperNum", column="paper_num"), 
			@Result(property="city", column="city_id", 
			one=@One(select="com.unconme.sgg.dao.mapper.CityMapper.selectByPrimaryKey",
					fetchType=FetchType.EAGER)), 
			@Result(property="rank", column="school_id", 
			one=@One(select="com.unconme.sgg.dao.mapper.SchoolRankMapper.selectByPrimaryKey",
					fetchType=FetchType.EAGER)), 
			@Result(property="major", column="school_id", 
			many=@Many(select="com.unconme.sgg.dao.mapper.MajorMapper.selectBySchoolId",
					fetchType=FetchType.EAGER))})
	public School selectBySchoolId(@Param("school_id") String schoolId);
	
	
	@Select("SELECT * FROM school WHERE city_id IN (SELECT city_id FROM city WHERE city_name_ch=#{city_name})")
	@Results({
		@Result(property="chName", column="ch_name"), 
		@Result(property="enName", column="en_name"), 
		@Result(property="address", column="address"), 
		@Result(property="photoUrl", column="photo_url"),
		@Result(property="city", column="city_id", 
		one=@One(select="com.unconme.sgg.dao.Mapper.CityMapper.selectByPrimaryKey", 
				fetchType=FetchType.EAGER))
	})
	public List<School> selectSchoolByCity(@Param("city_name") String cityName);
	
	
	@Select("SELECT * FROM school WHERE ch_name=#{school_name}")
	@ResultMap(value = { "SchoolMap" })
	public School selectSchoolByName(@Param("school_name") String schoolName);

	@Select("SELECT ch_name FROM school WHERE ch_name LIKE CONCAT('%', #{part_name}, '%')")
	@Result(property = "chName", column = "ch_name")
	public List<String> selectSchoolsByFuzzyQuery(@Param("part_name") String partName);



}
