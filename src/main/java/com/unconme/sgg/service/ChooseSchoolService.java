/**
 * 
 */
package com.unconme.sgg.service;

import java.util.HashMap;
import java.util.List;

/**
 * @author zmddzf
 * @date 2020/06/12
 */
public interface ChooseSchoolService {
	
	
	public HashMap<String, List<Float>> requestRecService(HashMap<String, Object> info);
	/**
	 * 请求推荐系统服务,传入HashMap格式数据,返回HashMap推荐结果
	 * @param: HashMap<String, Object> info 用户信息
	 * @return: HashMap<String, Object> 推荐结果
	 */
	
	
	public List<String> getSchoolRank(List<String> list);
	/**
	 * 查询列表中学校的排名信息并排序, 以QS列表为准
	 * @param: List<String> list 待排序列表
	 * @return: List<String> 排序后列表
	 */
	
	public HashMap<String, Object> queryResult(String openId, HashMap<String, Object> info);
	/**
	 * 返回最终查询结果
	 * @param: String openId 微信用户开放id, HashMap<String, Object> info 用户背景信息
	 * @return: HashMap<String, Object> 选校结果
	 */
	

}
