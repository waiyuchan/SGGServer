/**
 * 
 */
package com.unconme.sgg.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gitee.sunchenbin.mybatis.actable.manager.common.BaseMysqlCRUDManager;
import com.unconme.sgg.dao.mapper.SchoolMapper;
import com.unconme.sgg.dao.mapper.SchoolRankMapper;
import com.unconme.sgg.entity.ChooseSchoolRecord;
import com.unconme.sgg.entity.School;
import com.unconme.sgg.entity.SchoolRank;
import com.unconme.sgg.service.ChooseSchoolService;

/**
 * @author dzf
 * @date 2020/06/02
 */

@Service
public class ChooseSchoolServiceImpl implements ChooseSchoolService {
	
	@Autowired
	private SchoolRankMapper rankMapper;
	
	@Autowired
	private SchoolMapper schoolMapper;
	
	@Autowired
	private BaseMysqlCRUDManager baseMysqlCRUDManager;

	
	@Override
	public HashMap<String, List<Float>> requestRecService(HashMap<String, Object> info) {
		
		// 定义url字符串
		String url = "http://111.230.142.105:80/api/v1/recommend";
		// 初始化post请求
		HttpPost post = new HttpPost(url);
		
		// 将用户背景信息转为JSON
		JSONObject jsonObj=new JSONObject(info);
		// 构建请求entity
		StringEntity dataEntity = new StringEntity(jsonObj.toString(), ContentType.APPLICATION_JSON);
		// 加入post请求参数
		post.setEntity(dataEntity);
		
		// 用该实例发起请求
		CloseableHttpClient http = HttpClients.createDefault();
		
        try {
        	// 发起请求
        	CloseableHttpResponse response = http.execute(post);
        	
        	// 请求状态
        	int status = response.getStatusLine().getStatusCode();
        	
        	// 判断是否请求失败
        	if(status == 500) {
        		return null;  // 失败返回null
        	}
        	
        	// 获取响应实体
        	String string = EntityUtils.toString(response.getEntity(), "utf-8");
        	// 转为json
        	JSONObject jsonData = new JSONObject(string);
        	
        	// 不存在data 直接返回
        	if (!jsonData.has("data")) {
        		return null;
        	}
        	
        	// 获取data
        	JSONObject data = jsonData.getJSONObject("data");
        	
        	// 关闭连接
        	http.close();
    	            	
    	    // 定义HashMap
    	    HashMap<String, List<Float>> dataMap = new HashMap<String, List<Float>>();
    	    
    	    // 遍历 将data转为HashMap
    	    Iterator<String> iterator = data.keys();
    	    while(iterator.hasNext()){
    	    	String key = iterator.next();
    	    	String value = data.optString(key);
    	    	List<String> valueList = Arrays.asList(value.replace("[", "").replace("]", "").split(","));
    	    	List<Float> list = new ArrayList();
    	    	for(int i=0; i < 2; i++) {
    	    		list.add(Float.parseFloat(valueList.get(i)));
    	    	}
    	    	dataMap.put(key, list);
    	    }
    	    
    	    return dataMap;
        				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return null;
	}


	/* (non-Javadoc)
	 * @see com.unconme.sgg.service.ChooseSchool#getSchoolRank(java.util.List)
	 */
	@Override
	public List<String> getSchoolRank(List<String> list) {
		
		// 定义排名-学校Map
		HashMap<Integer, String> rankSchoolMap = new HashMap<Integer, String>();
		
		SchoolRank rank = new SchoolRank();  // 排名实体
		School school = new School();  // 学校实体
		
		for(String sn: list) {
			school.setChName(sn);  // 学校中文名
			
			//System.out.println(school);
			
			School schoolInfo = schoolMapper.selectOne(school);  // 按名称查学校id
			
			//System.out.println(schoolInfo);
			String schoolId = schoolInfo.getSchoolId();  // 获取学校ID
			
			rank.setSchoolId(schoolId);
			SchoolRank rankInfo = rankMapper.selectOne(rank);  // 按学校ID查QS排名
			Integer qsRank = Integer.parseInt(rankInfo.getQsRank());
			rankSchoolMap.put(qsRank, sn);  // 加入键值
		}
		
		// 对排名进行排序
        Set<Integer> set = rankSchoolMap.keySet();
        Object[] arr = set.toArray();
        Arrays.sort(arr);
        
        // 实例化排名后列表
        List<String> schoolRankList = new ArrayList<String>();
        
        for(Object key:arr) {
        	// 按排名排列表
        	schoolRankList.add(rankSchoolMap.get(key));
        }
        
		return schoolRankList;
	}

	/* (non-Javadoc)
	 * @see com.unconme.sgg.service.ChooseSchool#queryResult(java.util.HashMap)
	 */
	@Override
	public HashMap<String, Object> queryResult(String openId, HashMap<String, Object> info) {
		
		// 获取推荐系统请求结果
		HashMap<String, List<Float>> dataMap = requestRecService(info);
		
		//System.out.println(dataMap);
		
		// 若未能请求成功返回null
		if(dataMap == null) {
			return null;
		}
		
		// 生成学校列表
		Set<String> set = dataMap.keySet();
		List<String> list = new ArrayList<String>(set);
		
		// 获取排序后的学校列表
		List<String> schoolRankList = getSchoolRank(list);
		
		// 定义结果
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		// 低档次学校
		HashMap<String, Object> lowMap = new HashMap<String, Object>();
		
		// 中档次学校
		HashMap<String, Object> middleMap = new HashMap<String, Object>();
		
		// 高档次学校
		HashMap<String, Object> highMap = new HashMap<String, Object>();
		
		// 生成返回结果
		for(int i = 0; i < schoolRankList.size(); i++) {
			String key = schoolRankList.get(i);
			Object value = dataMap.get(key);
			if (i < 2) {
				highMap.put(schoolRankList.get(i), value);
			} else {
				if (i < 6) {
					middleMap.put(key, value);
				} else {
					lowMap.put(key, value);
				}
			}
		}
		
		// 获取定校日期
		Date getDate = Calendar.getInstance().getTime();
		String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(getDate);
		
		System.out.println(dateStr);
		
		// 依次存储选校记录
		Set<String> keys1 = lowMap.keySet();
		for (String key : keys1) {
			ChooseSchoolRecord record1 = new ChooseSchoolRecord();
			record1.setSchoolLevel("low_level");
			record1.setSchoolName(key);
			record1.setOpenId(openId);
			record1.setChooseDate(dateStr);
			baseMysqlCRUDManager.save(record1);
		}
		
		Set<String> keys2 = middleMap.keySet();
		for (String key : keys2) {
			ChooseSchoolRecord record2 = new ChooseSchoolRecord();
			record2.setSchoolLevel("middle_level");
			record2.setSchoolName(key);
			record2.setOpenId(openId);
			record2.setChooseDate(dateStr);
			baseMysqlCRUDManager.save(record2);
		}
		
		
		Set<String> keys3 = highMap.keySet();
		for (String key : keys3) {
			ChooseSchoolRecord record3 = new ChooseSchoolRecord();
			record3.setSchoolLevel("high_level");
			record3.setSchoolName(key);
			record3.setOpenId(openId);
			record3.setChooseDate(dateStr);
			baseMysqlCRUDManager.save(record3);
		}
		
		result.put("low_level", lowMap);
		result.put("middle_level", middleMap);
		result.put("high_level", highMap);
		
		return result;
	}
	
}



