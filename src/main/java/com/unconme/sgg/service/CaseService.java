package com.unconme.sgg.service;

import java.util.HashMap;

/**
 * @author: Fuwei Feng
 * @version: 2020/7/6
 */
public interface CaseService {
    /**
     * 通过案例ID来获取对应案例的信息
     * @param caseId    案例ID
     * @return          对应的案例的相关信息
     */
    public HashMap<String, Object> getCaseInstance(String caseId);

    /**
     * 获取所有案例
     * @return List<StanCase> 返回所有申请案例
     */
    public HashMap<String, Object> getAllCases();

    /**
     * 通过学校名获取案例
     * @param schoolName    学校名
     * @return  List<StanCase> 返回对应学校的申请案例
     */
    public HashMap<String, Object> getCasesBySchool(String schoolName);

    /**
     * 通过专业名获取案例
     * @param majorName     专业名
     * @return  List<StanCase>  返回对应专业的申请案例
     */
    public HashMap<String, Object> getCasesByMajor(String majorName);

    /**
     * 通过学校名和专业名来获取案例
     * @param schoolName    学校名
     * @param majorName     专业名
     * @return  List<StanCase>  返回对应学校对应专业的申请案例
     */
    public HashMap<String, Object> getCases(String schoolName, String majorName);
}
