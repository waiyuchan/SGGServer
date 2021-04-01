/**
 * 
 */
package com.unconme.sgg.service;

import com.alibaba.fastjson.JSON;
import com.unconme.sgg.entity.*;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.List;
/**
 * @author lky
 * @date Jul 1, 2020
 */
public interface UserService {
	/**
	 * 编辑个人资料接口
	 * @param userId
	 * @param email
	 * @param phone
	 * @return 编辑后结果
	 */
	public HashMap<String, Object> editUserInfo(Integer userId, @Nullable String email, @Nullable String phone);

}
