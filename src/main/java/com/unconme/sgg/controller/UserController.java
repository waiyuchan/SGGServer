/**
 * 
 */
package com.unconme.sgg.controller;

import com.alibaba.fastjson.JSON;
import com.unconme.sgg.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
/**
 * @author lky
 * @date Jul 2, 2020
 */

@RestController
public class UserController {
	
	@Autowired
	private UserService userServiceImpl;
	
	@RequestMapping(value = "/users", method = RequestMethod.PATCH)
	@ResponseBody
	public Object userEdit(@RequestParam("user_id") Integer userId, @Nullable @RequestParam("email") String email, @Nullable @RequestParam("phone") String phone) {
		HashMap<String, Object> resultMap = userServiceImpl.editUserInfo(userId, email, phone);
		String jsonOutPut = JSON.toJSONString(resultMap);
		return jsonOutPut;
	}

}
