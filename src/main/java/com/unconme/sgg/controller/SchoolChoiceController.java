package com.unconme.sgg.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unconme.sgg.service.ChooseSchoolService;

/**
 * @author dzf
 * @date 2020/06/02
 */


@RestController
@RequestMapping("/choice")
public class SchoolChoiceController {
	
	@Autowired
	private ChooseSchoolService chooseSchoolServiceImpl;
	
	@GetMapping
	/**
	 * 这只是一个get测试
	 * 没有什么卵用但是我不想删掉了
	 * @return HashMap<String, Object> map
	 */
	public Object get() {
		HashMap<String, Object> info = new HashMap<String, Object>(){
			{
				put("gre", "0");
				put("gpa", "91");
				put("gmat", "0");
				put("school", "双非一本");
				put("marker", "我是陈喂鱼，我在百度戴尔等大厂实习过，我还有十几篇论文，一堆竞赛");
				put("ielts", "7.0");
				put("toefl","0");
				put("major","信息管理与信息系统");
		    }
		};
		
		String openId = "1x12372";
		
		HashMap<String, Object> map = chooseSchoolServiceImpl.queryResult(openId, info);
		return map;
	}
	
	@PostMapping
	/**
	 * 
	 * @return
	 */
	public Object post(@RequestBody Map<String,Object> reqMap) {
		// 获取请求参数
		String gpa = reqMap.get("gpa").toString();
		String school = reqMap.get("school").toString();
		String marker = reqMap.get("marker").toString();
		String ielts = reqMap.get("ielts").toString();
		String toefl = reqMap.get("toefl").toString();
		String major = reqMap.get("major").toString();
		String openId = reqMap.get("openId").toString();
				
		String gre = new String();
		String gmat = new String();
				
		if (reqMap.get("gre").toString().equals("0")) {
			gre = "321";
		} else {
			gre = reqMap.get("gre").toString();
		}
		
		if (reqMap.get("gmat").toString().equals("0")) {
			gmat = "690";
		} else {
			gmat = reqMap.get("gmat").toString();
		}
		
		// 建立HashMap
		HashMap<String, Object> info = new HashMap<String, Object>();
		info.put("gre", gre);
		info.put("gpa", gpa);
	    info.put("gmat", gmat);
	    info.put("school", school);
	    info.put("marker", marker);
	    info.put("ielts", ielts);
	    info.put("toefl", toefl);
	    info.put("major", major);
	    
	    //System.out.println(info);
	    
	    // 请求推荐接口
	    HashMap<String, Object> data = chooseSchoolServiceImpl.queryResult(openId, info);
		
	    // 出现失败
	    if (data == null) {
	    	HashMap<String, Object> result = new HashMap<String, Object>();
	    	result.put("state", "500");
	    	result.put("msg", "接口调取失败, 请检查请求参数是否正确");
	    	result.put("data", new HashMap());
	    	return result;
	    }
	    
	    // 构建请求结构体
	    HashMap<String, Object> result = new HashMap<String, Object>();
	    result.put("state", "200");
	    result.put("msg", "success");
	    result.put("data", data);
	    
		return result;
		
	}

}
