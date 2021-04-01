/**
 * 
 */
package com.unconme.sgg.service;

import org.springframework.lang.Nullable;

import java.util.HashMap;
/**
 * @author lky
 * @date Jun 26, 2020
 */
public interface CityService {
	
	/**
	 * 获取城市详情数据
	 * @param cityId
	 * @return
	 */
	public HashMap<String, Object> getCityInfo(String cityId);
	
	/**
	 * 获取热门城市列表
	 * @return
	 */
	public HashMap<String, Object> getCityList();
	
	/**
	 * 城市相关接口
	 * @param cityId
	 * @return
	 */
	public HashMap<String, Object> cityService(@Nullable String cityId);

}
