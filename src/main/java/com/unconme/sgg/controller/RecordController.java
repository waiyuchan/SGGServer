package com.unconme.sgg.controller;

import com.alibaba.fastjson.JSON;
import com.unconme.sgg.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author: Fuwei Feng
 * @version: 2020/8/3
 */
@RestController
@ResponseBody
public class RecordController {

    @Autowired
    private RecordService recordServiceImpl;

    @RequestMapping(value = "/records", method = RequestMethod.GET)
    public Object getRecords(@RequestParam(value = "open_id") String openId) {
        HashMap<String, Object> resultMap = recordServiceImpl.getSchoolRecord(openId);
        String jsonOutput = JSON.toJSONString(resultMap);
        return jsonOutput;
    }
}
