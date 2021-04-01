package com.unconme.sgg.dao.mapper;

import com.unconme.sgg.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

public interface CityMapper extends Mapper<City>{
	
	/**
	 * ���ݳ�����������ѯ����
	 * @param cityNameCh
	 * @return �ó��ж���
	 */
	@Select("SELECT city_name_ch, city_name_en, map_url, introduction, clothes, "
			+ "food, life, travel FROM city WHERE city_name_ch=#{city_name_ch}")
	@Results(id="cityMap", value={
			@Result(property="cityNameCh", column="city_name_ch"),
			@Result(property="cityNameEn", column="city_name_en"),
			@Result(property="mapUrl", column="map_url"),
			@Result(property="introduction", column="introduction"),
			@Result(property="clothes", column="clothes"),
			@Result(property="food", column="food"),
			@Result(property="life", column="life"),
			@Result(property="travel", column="travel")
	})
	public City selectByCityName(@Param("city_name_ch") String cityNameCh );
	
	/**
	 * ��ѯ���г���
	 * @return �������г��ж�����б�
	 */
	@Select("SELECT city_name_ch, city_name_en, city_photo_url FROM city")
	@Results({@Result(property="cityNameCh", column="city_name_ch"), 
		@Result(property="cityNameEn", column="city_name_en"),
		@Result(property="cityPhotoUrl", column="city_photo_url")})
	public List<City> selectAllCities();
}
