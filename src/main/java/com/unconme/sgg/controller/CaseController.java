package com.unconme.sgg.controller;

import com.alibaba.fastjson.JSON;
import com.unconme.sgg.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author: Fuwei Feng
 * @version: 2020/6/24
 */

@RestController
@ResponseBody
public class CaseController {

    @Autowired
    private CaseService caseServiceImpl;

    @RequestMapping(value = "/cases", method = RequestMethod.GET)
    public Object getAllCases(@Nullable @RequestParam(value = "school_name") String schoolName, @Nullable @RequestParam(value = "major_name") String majorName) {
        if (schoolName == null && majorName == null) {
            HashMap<String, Object> resultMap = caseServiceImpl.getAllCases();
            String jsonOutput = JSON.toJSONString(resultMap);
            return jsonOutput;
        } else if (schoolName != null && majorName == null) {
            HashMap<String, Object> resultMap = caseServiceImpl.getCasesBySchool(schoolName);
            String jsonOutput = JSON.toJSONString(resultMap);
            return jsonOutput;
        } else if (schoolName == null && majorName != null) {
            HashMap<String, Object> resultMap = caseServiceImpl.getCasesByMajor(majorName);
            String jsonOutput = JSON.toJSONString(resultMap);
            return jsonOutput;
        } else {
            HashMap<String, Object> resultMap = caseServiceImpl.getCases(schoolName, majorName);
            String jsonOutput = JSON.toJSONString(resultMap);
            return jsonOutput;
        }

    }


    @RequestMapping(value = "/cases/instance", method = RequestMethod.GET)
    public Object getInstanceCase(@RequestParam(value = "case_id") String caseId) {
        HashMap<String, Object> resultMap = caseServiceImpl.getCaseInstance(caseId);
        String jsonOutput = JSON.toJSONString(resultMap);
        return jsonOutput;
    }

}
