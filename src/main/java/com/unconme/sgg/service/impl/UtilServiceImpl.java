package com.unconme.sgg.service.impl;

import com.unconme.sgg.service.UtilService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Fuwei Feng
 * @version: 2020/7/14
 */
@Service
public class UtilServiceImpl implements UtilService {
    /**
     * 开销计算方法
     *
     * @param reqMap
     * @return
     */
    @Override
    public HashMap<String, Object> calculateCost(HashMap<String, Object> reqMap) {
        String country = reqMap.get("country").toString();
        String tuition = reqMap.get("tuition").toString();
        String eatingHabit = reqMap.get("eating_habit").toString();
        String shoppingHabit = reqMap.get("shopping_habit").toString();

        Double tuitionFee = Double.parseDouble(tuition);
        double foodFee;
        double shopFee;
        double costs = 0.0;

        if (eatingHabit.equals("自己做饭")) {
            // 一周40磅  51周
            foodFee = 2040;
        } else if (eatingHabit.equals("每月1-2次外出吃饭")) {
            foodFee = 2040 + 30;
        } else if (eatingHabit.equals("每周1-2次外出吃饭")) {
            foodFee = 2040 + 30 * 51;
        } else {
            foodFee = 2040 + 50 * 51;
        }

        if (shoppingHabit.equals("很少购物")) {
            shopFee = 30 * 6;
        } else if (shoppingHabit.equals("每月1-2次购物")) {
            shopFee = 100 * 12;
        } else if (shoppingHabit.equals("每周1-2次购物")) {
            shopFee = 50 * 51;
        } else {
            shopFee = 100 * 51;
        }

        if (country.equals("英国-伦敦")) {
            costs = tuitionFee + foodFee * 1.5 + shopFee * 1.5;

        } else {
            costs = tuitionFee + foodFee + shopFee;
        }

        HashMap<String, Object> data = new HashMap<>();
        data.put("cost", costs);

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 200);
        resultMap.put("msg", "success");
        resultMap.put("data", data);

        return  resultMap;
    }
    
    /**
     * 均分计算方法
     * @param reqMap
     * @return
     */
	@Override
	public HashMap<String, Object> calculateGpa(HashMap<String, Object> reqMap) {
		// TODO Auto-generated method stub
		List<HashMap<String, Object>> subjects = (List<HashMap<String, Object>>) reqMap.get("subjects");
		
		return null;
	}
}
