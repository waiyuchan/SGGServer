/**
 * 
 */
package com.unconme.sgg.service;

import com.unconme.sgg.entity.*;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.List;
/**
 * @author lky
 * @date Jul 2, 2020
 */
public interface FavoriteService {
	
	/**
	 * 我的-收藏夹接口
	 * @param userId
	 * @param module
	 * @return
	 */
	public HashMap<String, Object> getFavorite(Integer userId, @Nullable String module);
	
	/**
	 * 我的-加入收藏夹接口
	 * @param object
	 * @return
	 */
	public HashMap<String, Object> addFavorite(HashMap<String, Object> reqMap);
}
