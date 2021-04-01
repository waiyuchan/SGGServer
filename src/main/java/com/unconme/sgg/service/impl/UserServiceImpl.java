/**
 * 
 */
package com.unconme.sgg.service.impl;

import com.unconme.sgg.service.UserService;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.unconme.sgg.dao.mapper.UserMapper;
import com.unconme.sgg.entity.User;

/**
 * @author lky
 * @date Jul 1, 2020
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public HashMap<String, Object> editUserInfo(Integer userId, @Nullable String email, @Nullable String phone) {
		// TODO Auto-generated method stub
		User user = userMapper.selectByUid(userId);
		if (email != null){
			user.setEmail(email);
		}
		if (phone != null) {
			user.setPhone(phone);
		}

		Integer uid = userMapper.updateByPrimaryKeySelective(user);
		User newUser = userMapper.selectByPrimaryKey(uid);
		
		HashMap<String, Object> userInfo = new HashMap<>();
		userInfo.put("user_id", newUser.getUid());
		userInfo.put("user_name", newUser.getNickname());
		userInfo.put("email", newUser.getEmail());
		userInfo.put("phone", newUser.getPhone());
		
		/**
		 * 列表为空报错
		 */
		if (userInfo.isEmpty()) {
			HashMap<String, Object> resultMap = new HashMap<>();
			resultMap.put("status", 500);
			resultMap.put("msg", "接口调用失败");
			resultMap.put("data", userInfo);
		}
		/**
		 * 返回数据
		 */
		HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 200);
        resultMap.put("msg", "success");
        resultMap.put("data", userInfo);
        
		return resultMap;
	}

}
