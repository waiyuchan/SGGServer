/**
 * 
 */
package com.unconme.sgg.controller;

import com.alibaba.fastjson.JSON;
import com.unconme.sgg.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
/**
 * @author lky
 * @date Jun 28, 2020
 */

@RestController
public class CityController {
	
	@Autowired
	private CityService cityServiceImpl;
	
	/**
	 * 城市相关接口
	 * @param cityId（城市Id）
	 * @return JSON Object
	 */
	@RequestMapping(value = "/cities", method = RequestMethod.GET)
	@ResponseBody
	public Object getCitiesList(@Nullable @RequestParam(value = "city_id") String cityId) {
		HashMap<String, Object> resultMap = cityServiceImpl.cityService(cityId);
		String jsonOutPut = JSON.toJSONString(resultMap);
		return jsonOutPut;
	}
	
}
