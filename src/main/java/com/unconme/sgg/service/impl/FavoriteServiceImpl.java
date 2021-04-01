/**
 * 
 */
package com.unconme.sgg.service.impl;

import com.unconme.sgg.service.FavoriteService;
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
 * @date Jul 2, 2020
 */

@Service
public class FavoriteServiceImpl implements FavoriteService{
	
	@Autowired
	private FavoriteMapper collectMapper;
	
	@Override
	public HashMap<String, Object> getFavorite(Integer userId, @Nullable String module) {
		// TODO Auto-generated method stub
		List<Favorite> collectList = collectMapper.selectByUserId(userId);
		List<List<HashMap<String, Object>>> data = new ArrayList<>();
		List<HashMap<String, Object>> schoolList = new ArrayList<>();
		List<HashMap<String, Object>> majorList = new ArrayList<>();
		List<HashMap<String, Object>> caseList = new ArrayList<>();
		List<HashMap<String, Object>> gpaList = new ArrayList<>();
		List<HashMap<String, Object>> choiceList = new ArrayList<>();
		
		Iterator<Favorite> iterator = collectList.iterator();
		// 返回收藏夹所有内容
		if (module == null || module == "all") {
			while (iterator.hasNext()) {
				Favorite collect = iterator.next();
				
				// 收藏类型为学校
				if (collect.getCollectType() == "school") {
					HashMap<String, Object> collectInfo = new HashMap<>();
					collectInfo.put("school_id", collect.getSchool().getSchoolId());
					collectInfo.put("school_name_ch", collect.getSchool().getChName());
					collectInfo.put("school_name_en", collect.getSchool().getEnName());
					
					schoolList.add(collectInfo);
				}
				// 收藏的专业
				else if (collect.getCollectType() == "major") {
					HashMap<String, Object> collectInfo = new HashMap<>();
					collectInfo.put("major_id", collect.getMajor().getMajorId());
					collectInfo.put("major_name_ch", collect.getMajor().getMajorNameCh());
					collectInfo.put("major_name_en", collect.getMajor().getMajorNameEn());
					collectInfo.put("introduction", collect.getMajor().getIntroduction());
					
					majorList.add(collectInfo);
				}
				// 收藏的案例
				else if (collect.getCollectType() == "case") {
					HashMap<String, Object> collectInfo = new HashMap<>();
					int caseType = collect.getCaseType();
					if (caseType == 0) {
						collectInfo.put("case_id", collect.getWeiboCase().getCaseId());
					}
					else if (caseType == 1) {
						collectInfo.put("case_id", collect.getStanCase().getCaseId());
					}
					
					caseList.add(collectInfo);
				}
				// 收藏的均分计算结果
				else if (collect.getCollectType() == "gpa") {
					
				}
				// 收藏的定校结果
				else if (collect.getCollectType() == "choice") {
					
				}
				// 添加进数据列表
				data.add(schoolList);
				data.add(majorList);
				data.add(caseList);
				data.add(gpaList);
				data.add(choiceList);
			}
		}
		// 返回收藏的学校
		else if (module == "school") {
			while (iterator.hasNext()) {
				Favorite collect = iterator.next();
				if (collect.getCollectType() == "school") {
					HashMap<String, Object> collectInfo = new HashMap<>();
					collectInfo.put("school_id", collect.getSchool().getSchoolId());
					collectInfo.put("school_name_ch", collect.getSchool().getChName());
					collectInfo.put("school_name_en", collect.getSchool().getEnName());
					
					schoolList.add(collectInfo);
				}
				data.add(schoolList);
			}
		}
		// 返回收藏的专业
		else if (module == "major") {
			while (iterator.hasNext()) {
				Favorite collect = iterator.next();
				if (collect.getCollectType() == "major") {
					HashMap<String, Object> collectInfo = new HashMap<>();
					collectInfo.put("major_id", collect.getMajor().getMajorId());
					collectInfo.put("major_name_ch", collect.getMajor().getMajorNameCh());
					collectInfo.put("major_name_en", collect.getMajor().getMajorNameEn());
					collectInfo.put("introduction", collect.getMajor().getIntroduction());
					
					majorList.add(collectInfo);
				}
				data.add(majorList);
			}
		}
		// 返回收藏的案例
		else if (module == "case") {
			while (iterator.hasNext()) {
				Favorite collect = iterator.next();
				if (collect.getCollectType() == "case") {
					HashMap<String, Object> collectInfo = new HashMap<>();
					int caseType = collect.getCaseType();
					if (caseType == 0) {
						collectInfo.put("case_id", collect.getWeiboCase().getCaseId());
					}
					else if (caseType == 1) {
						collectInfo.put("case_id", collect.getStanCase().getCaseId());
					}
					
					caseList.add(collectInfo);
				}
				data.add(caseList);
			}
		}
		// 返回收藏的均分计算结果
		else if (module == "gpa") {
			while (iterator.hasNext()) {
				Favorite collect = iterator.next();
			}
		}
		// 返回收藏的定校结果
		else if (module == "choice") {
			while (iterator.hasNext()) {
				Favorite collect = iterator.next();
			}
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
	public HashMap<String, Object> addFavorite(HashMap<String, Object> reqMap) {
		// TODO Auto-generated method stub
		String user_id = reqMap.get("user_id").toString();
		
		return null;
	}

}
