package com.unconme.sgg.service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Fuwei Feng
 * @version: 2020/7/14
 */
public interface UtilService {

    /**
     * 开销计算方法
     * @param reqMap
     * @return
     */
    public HashMap<String, Object> calculateCost(HashMap<String, Object> reqMap);
    /**
     * 均分计算方法
     * @param reqMap
     * @return
     */
    public HashMap<String, Object> calculateGpa(HashMap<String, Object> reqMap);
}
