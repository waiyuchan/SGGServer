package com.unconme.sgg.service;

import java.util.HashMap;
import java.util.List;

/**
 * @author: Fuwei Feng
 * @version: 2020/7/6
 */
public interface SchoolService {
    /**
     * 通过不同的排行榜名称获取不同的院校排行榜
     * @param rankName  排行榜名称
     * @return  对应的排行榜的学校
     */
    public HashMap<String, Object> getSchoolRankTable(String rankName, int page, int size);

    /**
     * 通过学校名获得学校的详细信息，以及不同的信息参数查看学校的不同类型信息
     * @param schoolName
     * @param infoModule
     * @return
     */
    public HashMap<String, Object> getSchoolDetails(String schoolName, String infoModule);

    /**
     * 通过学校名来获得学校对应的专业的信息
     * @param schoolName    学校名
     * @param majorName     专业名
     * @return  学校专业的信息
     */
    public HashMap<String, Object> getSchoolMajor(String schoolName, String majorName);


	/**
	 * 学校详情页面-申请情况接口
	 * @param schoolId
	 * @return
	 */
	public HashMap<String, Object> getSchoolApplications(String schoolId);

	/**
	 * 学校详情页面-申请情况接口
	 * @param schoolId
	 * @return
	 */
	public HashMap<String, Object> getSchoolInfo(String schoolId);

	/**
	 * 学校详情页面-知名校友接口
	 * @param schoolId
	 * @return
	 */
	public HashMap<String, Object> getAlumnus(String schoolId);
	
	/**
	 * 我的-院校对比接口
	 * @param schoolName1 需要对比的第一个学校中文名
	 * @param schoolName2 需要对比的第二个学校中文名
	 * @return 对比结果
	 */
	public HashMap<String, Object> getSchoolsCompare(String schoolName1, String schoolName2);
	
	/**
	 * 我的-专业对比接口
	 * @param schoolName1 需要对比的第一个学校中文名
	 * @param schoolName2 需要对比的第二个学校中文名
	 * @param majorName 专业英文名
	 * @return 对比结果
	 */
	HashMap<String, Object> getSchoolsMajorCompare(String schoolName1, String schoolName2, String majorName);

	/**
	 * 根据学校名进行模糊查询
	 * @param schoolChar	进行模糊查询的学校部分名称
	 * @return	列表形式的学校名
	 */
	public List<String> fuzzyQuerySchool(String schoolChar);

}
