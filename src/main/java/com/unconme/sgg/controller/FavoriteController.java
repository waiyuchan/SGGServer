/**
 * 
 */
package com.unconme.sgg.controller;

import com.alibaba.fastjson.JSON;
import com.unconme.sgg.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
/**
 * @author lky
 * @date Jul 11, 2020
 */
@RestController
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteServiceImpl;
	
	@RequestMapping(value = "/favorites", method = RequestMethod.GET)
	@ResponseBody
	public Object getFavorite(@RequestParam("user_id") Integer userId, @Nullable @RequestParam("module") String module) {
		HashMap<String, Object> resultMap = favoriteServiceImpl.getFavorite(userId, module);
		String jsonOutPut = JSON.toJSONString(resultMap);
		return jsonOutPut;
	}
	
	@RequestMapping(value = "/favorites", method = RequestMethod.PUT)
	@ResponseBody
	public Object addFavorite(@RequestBody HashMap<String, Object> param) {
		HashMap<String, Object> resultMap = favoriteServiceImpl.addFavorite(param);
		String jsonOutPut = JSON.toJSONString(resultMap);
		return jsonOutPut;
	}

}
