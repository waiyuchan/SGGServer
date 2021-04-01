
package com.unconme.sgg.controller;

import com.alibaba.fastjson.JSON;
import com.unconme.sgg.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


/**
 * @author: Fuwei Feng
 * @version: 2020/7/6
 */
@RestController
@ResponseBody
@RequestMapping(value = "/school")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolServiceImpl;
	
	// 院校详情
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@ResponseBody
	public Object getSchoolInfo(@RequestParam(value="school_id") String schoolId) {
		HashMap<String, Object> resultMap = schoolServiceImpl.getSchoolInfo(schoolId);
		String jsonOutPut = JSON.toJSONString(resultMap);
		return jsonOutPut;
	}
	
	// 院校申请情况
	@RequestMapping(value = "/apply", method = RequestMethod.GET)
	@ResponseBody
	public Object getSchoolApply(@RequestParam("school_id") String schoolId) {
		HashMap<String, Object> resultMap = schoolServiceImpl.getSchoolApplications(schoolId);
		String jsonOutPut = JSON.toJSONString(resultMap);
		return jsonOutPut;
	}
	
	// 院校校友
	@RequestMapping(value = "/alumnus", method = RequestMethod.GET)
	@ResponseBody
	public Object getSchoolAlumnus(@RequestParam("school_id") String schoolId) {
		HashMap<String, Object> resultMap = schoolServiceImpl.getAlumnus(schoolId);
		String jsonOutPut = JSON.toJSONString(resultMap);
		return jsonOutPut;
	}
	
	// 院校对比
	@RequestMapping(value = "/compare", method = RequestMethod.GET)
	@ResponseBody
	public Object getSchoolsCompare(@RequestParam("school_name1") String schoolName1, @RequestParam("school_name2") String schoolName2) {
		HashMap<String, Object> resultMap = schoolServiceImpl.getSchoolsCompare(schoolName1, schoolName2);
		String jsonOutPut = JSON.toJSONString(resultMap);
		return jsonOutPut;
	}
	
	// 专业对比
	@RequestMapping(value = "/major_compare", method = RequestMethod.GET)
	@ResponseBody
	public Object getSchoolsMajorCompare(@RequestParam("school_name1") String schoolName1, @RequestParam("school_name2") String schoolName2, @RequestParam("major_name") String majorName) {
		HashMap<String, Object> resultMap = schoolServiceImpl.getSchoolsMajorCompare(schoolName1, schoolName2, majorName);
		String jsonOutPut = JSON.toJSONString(resultMap);
		return jsonOutPut;
	}

    @RequestMapping(method = RequestMethod.GET)
    public Object getSchoolDetail(@RequestParam("school_name") String schoolName,
                                  @Nullable @RequestParam("info_module") String infoModule) {
        HashMap<String, Object> resultMap = schoolServiceImpl.getSchoolDetails(schoolName, infoModule);
        String jsonOutput = JSON.toJSONString(resultMap);
        return jsonOutput;
    }

    @RequestMapping(value = "/major", method = RequestMethod.GET)
    public Object getSchoolMajor(@RequestParam("school_name") String schoolName, @Nullable @RequestParam("major_name") String majorName) {
        HashMap<String, Object> resultMap = schoolServiceImpl.getSchoolMajor(schoolName, majorName);
        String jsonOutput = JSON.toJSONString(resultMap);
        return jsonOutput;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object getSchoolList(@Nullable @RequestParam(value = "list_name") String listName, @RequestParam(value = "page") int page, @RequestParam(value = "size") int size) {
        if (listName == null) {
            HashMap<String, Object> resultMap = schoolServiceImpl.getSchoolRankTable("QSRank", page, size);
            String jsonOutput = JSON.toJSONString(resultMap);
            return jsonOutput;
        } else {
            HashMap<String, Object> resultMap = schoolServiceImpl.getSchoolRankTable(listName, page, size);
            String jsonOutput = JSON.toJSONString(resultMap);
            return jsonOutput;
        }
    }

	/**
	 * 模糊查询接口
	 * @param partName	用户输入的部分学校名
	 * @return	list格式的学校名称
	 */
	@RequestMapping(value = "/fuzzyQuery", method = RequestMethod.GET)
	public Object getSchoolsByFuzzyQuery(@RequestParam(value = "part_name") String partName) {
		List<String> schoolsList = schoolServiceImpl.fuzzyQuerySchool(partName);
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "200");
		resultMap.put("msg", "success");
		resultMap.put("data", schoolsList);
		return resultMap;
	}
}
