package com.unconme.sgg.controller;

import com.alibaba.fastjson.JSON;
import com.unconme.sgg.service.UtilService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Fuwei Feng
 * @version: 2020/7/14
 */
@RestController
@ResponseBody
public class UtilController {

    @Autowired
    private UtilService utilServiceImpl;

    @RequestMapping(value="/costs", method= RequestMethod.POST)
    public Object getCosts(@RequestBody HashMap<String, Object> param) {
        HashMap<String, Object> resultMap = utilServiceImpl.calculateCost(param);
        String jsonOutput = JSON.toJSONString(resultMap);
        return jsonOutput;
    }
}
