/**
 * 
 */
package com.unconme.sgg.service.impl;

import com.unconme.sgg.service.CityService;
import com.unconme.sgg.dao.mapper.*;
import com.unconme.sgg.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
/**
 * @author lky
 * @date Jun 26, 2020
 */
@Service
public class CityServiceImpl implements CityService{
	
	@Autowired
	private CityMapper cityMapper;
	
	@Override
	public HashMap<String, Object> getCityInfo(String cityId) {
		// TODO Auto-generated method stub
		City city = cityMapper.selectByPrimaryKey(cityId);
		HashMap<String, Object> cityIntro = new HashMap<>();
		cityIntro.put("city_name_ch", city.getCityNameCh());
		cityIntro.put("city_name_en", city.getCityNameEn());
		cityIntro.put("map_url", city.getMapUrl());
		cityIntro.put("introduction", city.getIntroduction());
		cityIntro.put("clothes", city.getClothes());
		cityIntro.put("food", city.getFood());
		cityIntro.put("life", city.getLife());
		cityIntro.put("travel", city.getTravel());
		

		// 数据为空，调用接口失败
		if (cityIntro.isEmpty()) {
			HashMap<String, Object> resultMap = new HashMap<>();
			resultMap.put("status", 500);
			resultMap.put("msg", "接口调用失败");
			resultMap.put("data", cityIntro);
		}
		
		// 数据不为空，返回数据
		HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 200);
        resultMap.put("msg", "success");
        resultMap.put("data", cityIntro);
        
		return resultMap;
	}

	@Override
	public HashMap<String, Object> getCityList() {
		// TODO Auto-generated method stub
		List<City> cityList = cityMapper.selectAllCities();
		List<HashMap<String, Object>> data = new ArrayList<>();
		Iterator<City> iterator = cityList.iterator();
		while (iterator.hasNext()) {
			City city = iterator.next();
			String cityNameCh = city.getCityNameCh();
			String cityNameEn = city.getCityNameEn();
			String cityPhotoUrl = city.getCityPhotoUrl();
			
			// 创建HashMap存放单个城市信息
			HashMap<String, Object> singleCityInfo = new HashMap<>();
			singleCityInfo.put("city_name_ch", cityNameCh);
			singleCityInfo.put("city_name_en", cityNameEn);
			singleCityInfo.put("city_photo_url", cityPhotoUrl);
			
			// 添加进列表
			data.add(singleCityInfo);
		}
		// 列表为空则返回错误信息
		if (data.isEmpty()) {
			HashMap<String, Object> resultMap = new HashMap<>();
			resultMap.put("status", 500);
			resultMap.put("msg", "调用接口失败");
			resultMap.put("data", data);
		}
		// 不为空则返回数据和状态码
		HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 200);
        resultMap.put("msg", "success");
        resultMap.put("data", data);
        
		return resultMap;
	}

	@Override
	public HashMap<String, Object> cityService(@Nullable String cityId){
		// TODO Auto-generated method stub
		// 若cityId为空则返回城市列表
		if (cityId == null) {
			return getCityList();
		}
		
		// cityId参数不为空则返回该城市详情数据
		else {
			return getCityInfo(cityId);
		}
	}
}
