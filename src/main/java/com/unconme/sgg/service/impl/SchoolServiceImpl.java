package com.unconme.sgg.service.impl;

import com.unconme.sgg.dao.mapper.*;
import com.unconme.sgg.entity.*;
import com.unconme.sgg.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.unconme.sgg.dao.mapper.MajorMapper;
import com.unconme.sgg.dao.mapper.SchoolMapper;
import com.unconme.sgg.dao.mapper.SchoolsAlumnusMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


/**
 * @author: Fuwei Feng
 * @version: 2020/7/6
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;
    @Autowired
    private SchoolRankMapper schoolRankMapper;
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private StanCaseMapper stanCaseMapper;
    @Autowired
    private ApplicantMapper applicantMapper;
    @Autowired
    private SchoolsAlumnusMapper schoolsAlumnusMapper;
    @Autowired
    private AlumnusMapper alumnusMapper;
    @Autowired
    private CityMapper cityMapper;

    /**
     * 通过不同的排行榜名称获取不同的院校排行榜
     *
     * @param rankName 排行榜名称
     * @return 对应的排行榜的学校
     */
    @Override
    public HashMap<String, Object> getSchoolRankTable(String rankName, int page, int size) {
        if (rankName.compareTo("QSRank") == 0) {
            List<String> schoolsId = schoolRankMapper.getSchoolIdByQS();
            List<HashMap<String, Object>> schoolsList = new ArrayList<>();

            for (String schoolId : schoolsId) {
                HashMap<String, Object> schoolMap = new HashMap<>();
                School school = schoolMapper.selectBySchoolId(schoolId);
                SchoolRank schoolRank = schoolRankMapper.selectByPrimaryKey(schoolId);
                String sId = school.getSchoolId();
                String cnName = school.getChName();
                String enName = school.getEnName();
                String qsRank = schoolRank.getQsRank();
                String timesRank = schoolRank.getTimesRank();
                String country = school.getCityId();
                String schoolIcon = "";
                String rankLevel = "";

                schoolMap.put("schoolid", sId);
                schoolMap.put("school_name_ch", cnName);
                schoolMap.put("school_name_en", enName);
                schoolMap.put("qs_rank", qsRank);
                schoolMap.put("times_rank", timesRank);
                schoolMap.put("country", country);
                schoolMap.put("school_icon", schoolIcon);
                schoolMap.put("rank_level", rankLevel);

                schoolsList.add(schoolMap);
            }

            // 通过page和size选取展示出来的学校
            List newList = schoolsList.subList((page - 1) * size, page * size);

            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("status", 200);
            resultMap.put("msg", "success");
            resultMap.put("data", newList);

            return resultMap;

        } else if (rankName.compareTo("TimesRank") == 0) {

            List<String> schoolsId = schoolRankMapper.getSchoolIdByTimes();
            List<HashMap<String, Object>> schoolsList = new ArrayList<>();

            for (String schoolId : schoolsId) {
                HashMap<String, Object> schoolMap = new HashMap<>();
                School school = schoolMapper.selectBySchoolId(schoolId);
                SchoolRank schoolRank = schoolRankMapper.selectByPrimaryKey(schoolId);
                String sId = school.getSchoolId();
                String cnName = school.getChName();
                String enName = school.getEnName();
                String qsRank = schoolRank.getQsRank();
                String timesRank = schoolRank.getTimesRank();
                String country = school.getCityId();
                String schoolIcon = "";
                String rankLevel = "";

                schoolMap.put("schoolid", sId);
                schoolMap.put("school_name_ch", cnName);
                schoolMap.put("school_name_en", enName);
                schoolMap.put("qs_rank", qsRank);
                schoolMap.put("times_rank", timesRank);
                schoolMap.put("country", country);
                schoolMap.put("school_icon", schoolIcon);
                schoolMap.put("rank_level", rankLevel);

                schoolsList.add(schoolMap);
            }

            List newList = schoolsList.subList((page - 1) * size, page * size);
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("status", 200);
            resultMap.put("msg", "success");
            resultMap.put("data", newList);

            return resultMap;

        } else if (rankName.compareTo("ShangJiaoRank") == 0) {
            List<String> schoolsId = schoolRankMapper.getSchoolIdBySJ();
            List<HashMap<String, Object>> schoolsList = new ArrayList<>();

            for (String schoolId : schoolsId) {
                HashMap<String, Object> schoolMap = new HashMap<>();
                School school = schoolMapper.selectBySchoolId(schoolId);
                SchoolRank schoolRank = schoolRankMapper.selectByPrimaryKey(schoolId);
                String sId = school.getSchoolId();
                String cnName = school.getChName();
                String enName = school.getEnName();
                String qsRank = schoolRank.getQsRank();
                String timesRank = schoolRank.getTimesRank();
                String country = school.getCityId();
                String schoolIcon = "";
                String rankLevel = "";

                schoolMap.put("schoolid", sId);
                schoolMap.put("school_name_ch", cnName);
                schoolMap.put("school_name_en", enName);
                schoolMap.put("qs_rank", qsRank);
                schoolMap.put("times_rank", timesRank);
                schoolMap.put("country", country);
                schoolMap.put("school_icon", schoolIcon);
                schoolMap.put("rank_level", rankLevel);

                schoolsList.add(schoolMap);
            }

            List newList = schoolsList.subList((page - 1) * size, page * size);
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("status", 200);
            resultMap.put("msg", "success");
            resultMap.put("data", newList);

            return resultMap;
        } else {
            return null;
        }
    }

    /**
     * @param schoolName
     * @param infoModule
     * @return
     */
    @Override
    public HashMap<String, Object> getSchoolDetails(String schoolName, String infoModule) {
        if (infoModule == null) {
            HashMap<String, Object> data = new HashMap<>();

            // 获取school_info信息
            HashMap<String, Object> school_info = new HashMap<>();
            School school = new School();
            school.setChName(schoolName);
            School schoolExample = schoolMapper.selectOne(school);
            SchoolRank schoolRank = schoolRankMapper.selectByPrimaryKey(schoolExample.getSchoolId());
            school_info.put("schoolid", schoolExample.getSchoolId());
            school_info.put("schoolname_ch", schoolExample.getChName());
            school_info.put("schoolname_en", schoolExample.getEnName());
            school_info.put("location", schoolExample.getLocation());
            school_info.put("schoolgraph", "");
            school_info.put("schooltitle", schoolExample.getHistory());
            school_info.put("qs_rank", schoolRank.getQsRank());
            school_info.put("times_rank", schoolRank.getTimesRank());

            // 获取apply_info信息
            HashMap<String, Object> apply_info = new HashMap<>();
            Major major = majorMapper.selectMajorBySchoolId(schoolExample.getSchoolId());
            apply_info.put("open_date", "2020.09");
            apply_info.put("days", "260");
            apply_info.put("required_ielts", major.getLanguageCon());
            apply_info.put("acceptance_rate", schoolExample.getRejectRate());
            apply_info.put("average_offer_speed", schoolExample.getAverageOfferSpeed());
            apply_info.put("tution_fee", schoolExample.getTuitionFee());
            apply_info.put("living_fee", schoolExample.getLifeFee());
            apply_info.put("school_system", major.getSchoolingLength());

            // 获取apply_cases信息
            List<HashMap<String, Object>> apply_cases = new ArrayList<>();
            List<StanCase> casesList = stanCaseMapper.selectBySchoolId(schoolExample.getSchoolId());
            for (StanCase singleCase : casesList) {
                HashMap<String, Object> applyCase = new HashMap<>();
                Applicant applicant = applicantMapper.selectByAid(singleCase.getAid());
                Major majorExample = majorMapper.selectByMajorId(singleCase.getMajor());
                applyCase.put("case_id", singleCase.getCaseId());
                applyCase.put("applicant", singleCase.getAid());
                applyCase.put("ug_level", applicant.getUgSchool());
                applyCase.put("ug_gpa", applicant.getUgGpa());
                applyCase.put("major_ch", majorExample.getMajorNameCh());
                applyCase.put("major_en", majorExample.getMajorNameEn());
                applyCase.put("apply_type", singleCase.getDegree());
                applyCase.put("major_rank", majorExample.getRank());
                applyCase.put("offer_date", singleCase.getResultDate());
                apply_cases.add(applyCase);
            }

            // 获取热门专业信息
            List<HashMap<String, Object>> popular_majors = new ArrayList<>();
            List<Major> majorsList = majorMapper.selectPopularMajors(schoolExample.getSchoolId());
            for (Major singleMajor : majorsList) {
                HashMap<String, Object> popularMajor = new HashMap<>();
                popularMajor.put("major_ch", singleMajor.getMajorNameCh());
                popularMajor.put("major_en", singleMajor.getMajorNameEn());
                popular_majors.add(popularMajor);
            }

            // 获取知名校友
            List<HashMap<String, Object>> famous_alumni = new ArrayList<>();
            List<SchoolsAlumnus> schoolAlumnusList = schoolsAlumnusMapper.selectBySchoolId(schoolExample.getSchoolId());
            for (SchoolsAlumnus schoolsAlumnus : schoolAlumnusList) {

                HashMap<String, Object> alumni = new HashMap<>();
                Alumnus alumnus = alumnusMapper.selectByPrimaryKey(schoolsAlumnus.getAlumnusId());
                alumni.put("name", alumnus.getAlumnusId());
                alumni.put("title", alumnus.getIntroduction());
            }

            data.put("school_info", school_info);
            data.put("apply_info", apply_info);
            data.put("apply_cases", apply_cases);
            data.put("popular_majors", popular_majors);
            data.put("famous_alumni", famous_alumni);

            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("status", 200);
            resultMap.put("msg", "success");
            resultMap.put("data", data);

            return resultMap;
        } else if (infoModule.compareTo("schoolInfo") == 0){
            HashMap<String, Object> school_info = new HashMap<>();
            School school = new School();
            school.setChName(schoolName);
            School schoolExample = schoolMapper.selectOne(school);
            SchoolRank schoolRank = schoolRankMapper.selectByPrimaryKey(schoolExample.getSchoolId());
            school_info.put("schoolid", schoolExample.getSchoolId());
            school_info.put("schoolname_ch", schoolExample.getChName());
            school_info.put("schoolname_en", schoolExample.getEnName());
            school_info.put("location", schoolExample.getLocation());
            school_info.put("schoolgraph", "");
            school_info.put("schooltitle", schoolExample.getHistory());
            school_info.put("qs_rank", schoolRank.getQsRank());
            school_info.put("times_rank", schoolRank.getTimesRank());

            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("status", 200);
            resultMap.put("msg", "success");
            resultMap.put("data", school_info);

            return resultMap;
        } else if (infoModule.compareTo("applyInfo") == 0){
            // 获取apply_info信息
            HashMap<String, Object> apply_info = new HashMap<>();
            School school = new School();
            school.setChName(schoolName);
            School schoolExample = schoolMapper.selectOne(school);
            Major major = majorMapper.selectMajorBySchoolId(schoolExample.getSchoolId());
            apply_info.put("open_date", "2020.09");
            apply_info.put("days", "260");
            apply_info.put("required_ielts", major.getLanguageCon());
            apply_info.put("acceptance_rate", schoolExample.getRejectRate());
            apply_info.put("average_offer_speed", schoolExample.getAverageOfferSpeed());
            apply_info.put("tution_fee", schoolExample.getTuitionFee());
            apply_info.put("living_fee", schoolExample.getLifeFee());
            apply_info.put("school_system", major.getSchoolingLength());

            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("status", 200);
            resultMap.put("msg", "success");
            resultMap.put("data", apply_info);
            return resultMap;
        } else if (infoModule.compareTo("applyCases") == 0) {
            List<HashMap<String, Object>> apply_cases = new ArrayList<>();
            School school = new School();
            school.setChName(schoolName);
            School schoolExample = schoolMapper.selectOne(school);
            List<StanCase> casesList = stanCaseMapper.selectBySchoolId(schoolExample.getSchoolId());
            for (StanCase singleCase : casesList) {
                HashMap<String, Object> applyCase = new HashMap<>();
                Applicant applicant = applicantMapper.selectByAid(singleCase.getAid());
                Major majorExample = majorMapper.selectByMajorId(singleCase.getMajor());
                applyCase.put("case_id", singleCase.getCaseId());
                applyCase.put("applicant", singleCase.getAid());
                applyCase.put("ug_level", applicant.getUgSchool());
                applyCase.put("ug_gpa", applicant.getUgGpa());
                applyCase.put("major_ch", majorExample.getMajorNameCh());
                applyCase.put("major_en", majorExample.getMajorNameEn());
                applyCase.put("apply_type", singleCase.getDegree());
                applyCase.put("major_rank", majorExample.getRank());
                applyCase.put("offer_date", singleCase.getResultDate());
                apply_cases.add(applyCase);
            }
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("status", 200);
            resultMap.put("msg", "success");
            resultMap.put("data", apply_cases);
            return resultMap;
        } else if (infoModule.compareTo("popularMajors") == 0) {
            List<HashMap<String, Object>> popular_majors = new ArrayList<>();
            School school = new School();
            school.setChName(schoolName);
            School schoolExample = schoolMapper.selectOne(school);
            List<Major> majorsList = majorMapper.selectPopularMajors(schoolExample.getSchoolId());
            for (Major singleMajor : majorsList) {
                HashMap<String, Object> popularMajor = new HashMap<>();
                popularMajor.put("major_ch", singleMajor.getMajorNameCh());
                popularMajor.put("major_en", singleMajor.getMajorNameEn());
                popular_majors.add(popularMajor);
            }

            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("status", 200);
            resultMap.put("msg", "success");
            resultMap.put("data", popular_majors);
            return resultMap;
        } else if (infoModule.compareTo("famousAlumni") == 0) {
            List<HashMap<String, Object>> famous_alumni = new ArrayList<>();
            School school = new School();
            school.setChName(schoolName);
            School schoolExample = schoolMapper.selectOne(school);
            List<SchoolsAlumnus> schoolAlumnusList = schoolsAlumnusMapper.selectBySchoolId(schoolExample.getSchoolId());
            for (SchoolsAlumnus schoolsAlumnus : schoolAlumnusList) {

                HashMap<String, Object> alumni = new HashMap<>();
                Alumnus alumnus = alumnusMapper.selectByPrimaryKey(schoolsAlumnus.getAlumnusId());
                alumni.put("name", alumnus.getAlumnusId());
                alumni.put("title", alumnus.getIntroduction());
            }


            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("status", 200);
            resultMap.put("msg", "success");
            resultMap.put("data", famous_alumni);

            return resultMap;
        } else {
            return null;
        }
    }

    /**
     * 通过学校名来获得学校对应的专业的信息
     *
     * @param schoolName 学校名
     * @param majorName 专业名
     * @return 学校专业的信息
     */
    @Override
    public HashMap<String, Object> getSchoolMajor(String schoolName, String majorName) {
        if (majorName == null) {
            List<HashMap<String, Object>> data = new ArrayList<>();
            School school = new School();
            school.setChName(schoolName);
            School schoolInfo = schoolMapper.selectOne(school);
            List<Major> majors = majorMapper.selectBySchoolId(schoolInfo.getSchoolId());

            for (Major major : majors) {
                HashMap<String, Object> majorInfo = new HashMap<>();
                majorInfo.put("major_ch", major.getMajorNameCh());
                majorInfo.put("major_en", major.getMajorNameEn());
                majorInfo.put("apply_type", major.getApplyType());
                majorInfo.put("major_rank", major.getRank());
                data.add(majorInfo);
            }

            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("status", 200);
            resultMap.put("msg", "success");
            resultMap.put("data", data);

            return resultMap;
        } else {
            HashMap<String, Object> data = new HashMap<>();
            // 获取major_info信息
            HashMap<String, Object> major_info = new HashMap<>();
            School test = new School();
            test.setChName(schoolName);
            School school = schoolMapper.selectOne(test);
            Major major = majorMapper.selectBySchoolIdAndMajorCnName(school.getSchoolId(), majorName);
            City city = cityMapper.selectByPrimaryKey(school.getCityId());
            major_info.put("major_ch", major.getMajorNameCh());
            major_info.put("major_en", major.getMajorNameEn());
            major_info.put("city", city.getIntroduction());
            major_info.put("college", "");
            major_info.put("qs_rank", major.getRank());
            major_info.put("school_intro", school.getHistory());

            // 获取apply_info信息
            HashMap<String, Object> apply_info = new HashMap<>();
            apply_info.put("open_date", "2020.09");
            apply_info.put("days", "260");
            apply_info.put("required_ielts", major.getLanguageCon());
            apply_info.put("acceptance_rate", school.getRejectRate());
            apply_info.put("average_offer_speed", school.getAverageOfferSpeed());
            apply_info.put("tuition_fee", school.getTuitionFee());
            apply_info.put("living_fee", school.getLifeFee());

            // 获取popular_majors信息
            List<HashMap<String, Object>> popular_majors = new ArrayList<>();
            List<Major> majorsList = majorMapper.selectPopularMajors(school.getSchoolId());
            for (Major singleMajor : majorsList) {
                HashMap<String, Object> popularMajor = new HashMap<>();
                popularMajor.put("major_ch", singleMajor.getMajorNameCh());
                popularMajor.put("major_en", singleMajor.getMajorNameEn());
                popular_majors.add(popularMajor);
            }

            // 获取apply_cases信息
            List<HashMap<String, Object>> apply_cases = new ArrayList<>();
            List<StanCase> casesList = stanCaseMapper.selectByMajor(major.getMajorId());
            for (StanCase singleCase : casesList) {
                HashMap<String, Object> applyCase = new HashMap<>();
                Applicant applicant = applicantMapper.selectByAid(singleCase.getAid());
                Major majorExample = majorMapper.selectByMajorId(singleCase.getMajor());
                applyCase.put("applicant", singleCase.getAid());
                applyCase.put("ug_level", applicant.getUgSchool());
                applyCase.put("ug_gpa", applicant.getUgGpa());
                applyCase.put("major_ch", majorExample.getMajorNameCh());
                applyCase.put("major_en", majorExample.getMajorNameEn());
                applyCase.put("apply_type", singleCase.getDegree());
                applyCase.put("major_rank", majorExample.getRank());
                applyCase.put("offer_date", singleCase.getResultDate());
                apply_cases.add(applyCase);
            }
            // 获取奖学金信息
            HashMap<String, Object> scholarship = new HashMap<>();
            scholarship.put("scholarship_apply_url", "");

            data.put("major_info", major_info);
            data.put("apply_info", apply_info);
            data.put("popular_majors", popular_majors);
            data.put("apply_cases", apply_cases);
            data.put("apply_cases", apply_cases);
            data.put("scholarship", scholarship);

            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("status", 200);
            resultMap.put("msg", "success");
            resultMap.put("data", data);

            return resultMap;
        }
    }


	@Override
	public HashMap<String, Object> getSchoolApplications(String schoolId) {
		// TODO Auto-generated method stub
		School school = schoolMapper.selectByPrimaryKey(schoolId);
		// 创建HashMap存放单个申请情况信息
		HashMap<String, Object> applyInfo = new HashMap<>();
		applyInfo.put("open_date", school.getOpenDate());
		applyInfo.put("days", school.getDays());
		applyInfo.put("required_ielts", school.getRequiredIelts());
		applyInfo.put("acceptance_rate", school.getRejectRate());
		applyInfo.put("average_offer_speed", school.getAverageOfferSpeed());
		applyInfo.put("living_fee", school.getLifeFee());
		applyInfo.put("tution_fee", school.getTuitionFee());

		/**
		 * 列表为空报错
		 */
		if (applyInfo.isEmpty()) {
			HashMap<String, Object> resultMap = new HashMap<>();
			resultMap.put("status", 500);
			resultMap.put("msg", "接口调用失败");
			resultMap.put("data", applyInfo);
		}
		/**
		 * 返回数据
		 */
		HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 200);
        resultMap.put("msg", "success");
        resultMap.put("data", applyInfo);

		return resultMap;
	}

	@Override
	public HashMap<String, Object> getSchoolInfo(String schoolId) {
		// TODO Auto-generated method stub
		School school = schoolMapper.selectBySchoolId(schoolId);
		HashMap<String, Object> schoolInfo = new HashMap<>();
		schoolInfo.put("school_id", school.getSchoolId());
		schoolInfo.put("schoolname_ch", school.getChName());
		schoolInfo.put("schoolname_en", school.getEnName());
		schoolInfo.put("location", school.getLocation());
		schoolInfo.put("schoolgraph", school.getPhotoUrl());
		schoolInfo.put("schooltitle", school.getHistory());
		schoolInfo.put("qs_rank", school.getRank().getQsRank());
		schoolInfo.put("times_rank", school.getRank().getTimesRank());

		/**
		 * 列表为空报错
		 */
		if (schoolInfo.isEmpty()) {
			HashMap<String, Object> resultMap = new HashMap<>();
			resultMap.put("status", 500);
			resultMap.put("msg", "接口调用失败");
			resultMap.put("data", schoolInfo);
		}
		/**
		 * 返回数据
		 */
		HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 200);
        resultMap.put("msg", "success");
        resultMap.put("data", schoolInfo);

		return resultMap;
	}

	@Override
	public HashMap<String, Object> getAlumnus(String schoolId) {
		// TODO Auto-generated method stub
		List<SchoolsAlumnus> schoolsAlumnusList = schoolsAlumnusMapper.selectBySchoolId(schoolId);
		List<HashMap<String, Object>> data = new ArrayList<>();
		Iterator<SchoolsAlumnus> iterator = schoolsAlumnusList.iterator();
		while (iterator.hasNext()) {
			SchoolsAlumnus schoolsAlumnus = iterator.next();
			HashMap<String, Object> alumnusInfo = new HashMap<>();
			alumnusInfo.put("name", schoolsAlumnus.getAlumnus().getAlumnusName());
			alumnusInfo.put("title", schoolsAlumnus.getAlumnus().getIntroduction());
			
			// 添加进列表
			data.add(alumnusInfo);
		}

		/**
		 * 列表为空报错
		 */
		if (data.isEmpty()) {
			HashMap<String, Object> resultMap = new HashMap<>();
			resultMap.put("status", 500);
			resultMap.put("msg", "接口调用失败");
			resultMap.put("data", data);
		}
		/**
		 * 返回数据
		 */
		HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 200);
        resultMap.put("msg", "success");
        resultMap.put("data", data);

		return resultMap;

	}

	@Override
	public HashMap<String, Object> getSchoolsCompare(String schoolName1, String schoolName2) {
		// TODO Auto-generated method stub
		School school1 = schoolMapper.selectSchoolByName(schoolName1);
		School school2 = schoolMapper.selectSchoolByName(schoolName2);
		HashMap<String, Object> data = new HashMap<>();
		HashMap<String, Object> schoolInfo1 = new HashMap<>();
		HashMap<String, Object> schoolInfo2 = new HashMap<>();
		
		// 要对比的第一个院校信息
		schoolInfo1.put("school_name_ch", school1.getChName());
		schoolInfo1.put("qs_rank", school1.getRank().getQsRank());
		schoolInfo1.put("times_rank", school1.getRank().getTimesRank());
		schoolInfo1.put("employer_rating", school1.getEmployerRating());
		schoolInfo1.put("paper", school1.getPaperNum());
		// 要对比的第二个院校信息
		schoolInfo2.put("school_name_ch", school2.getChName());
		schoolInfo2.put("qs_rank", school2.getRank().getQsRank());
		schoolInfo2.put("times_rank", school2.getRank().getTimesRank());
		schoolInfo2.put("employer_rating", school2.getEmployerRating());
		schoolInfo2.put("paper", school2.getPaperNum());
		// 放进data里一起返回
		data.put("first_school", schoolInfo1);
		data.put("second_school", schoolInfo2);
		
		/**
		 * 列表为空报错
		 */
		if (data.isEmpty()) {
			HashMap<String, Object> resultMap = new HashMap<>();
			resultMap.put("status", 500);
			resultMap.put("msg", "接口调用失败");
			resultMap.put("data", data);
		}
		/**
		 * 返回数据
		 */
		HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 200);
        resultMap.put("msg", "success");
        resultMap.put("data", data);
        
		return resultMap;
	}

	@Override
	public HashMap<String, Object> getSchoolsMajorCompare(String schoolName1, String schoolName2, String majorName) {
		// TODO Auto-generated method stub
		School school1 = schoolMapper.selectSchoolByName(schoolName1);
		School school2 = schoolMapper.selectSchoolByName(schoolName2);
		Major major1 = majorMapper.selectBySchoolAndMajorName(schoolName1, majorName);
		Major major2 = majorMapper.selectBySchoolAndMajorName(schoolName2, majorName);
		HashMap<String, Object> data = new HashMap<>();
		HashMap<String, Object> schoolInfo1 = new HashMap<>();
		HashMap<String, Object> schoolInfo2 = new HashMap<>();
		
		// 要对比的第一个院校专业信息
		schoolInfo1.put("school_name_ch", school1.getChName());
		schoolInfo1.put("major_en", major1.getMajorNameEn());
		schoolInfo1.put("qs_rank", major1.getRank());
		schoolInfo1.put("tution_fee", major1.getTutionFee());
		schoolInfo1.put("academic_hours", major1.getAcademicHours());
		schoolInfo1.put("course_number", major1.getCourseNum());

		// 要对比的第二个院校专业信息
		schoolInfo2.put("school_name_ch", school2.getChName());
		schoolInfo2.put("major_en", major2.getMajorNameEn());
		schoolInfo2.put("qs_rank", major2.getRank());
		schoolInfo2.put("tution_fee", major2.getTutionFee());
		schoolInfo2.put("academic_hours", major2.getAcademicHours());
		schoolInfo2.put("course_number", major2.getCourseNum());
		// 放进data里一起返回
		data.put("first_school", schoolInfo1);
		data.put("second_school", schoolInfo2);
		
		/**
		 * 列表为空报错
		 */
		if (data.isEmpty()) {
			HashMap<String, Object> resultMap = new HashMap<>();
			resultMap.put("status", 500);
			resultMap.put("msg", "接口调用失败");
			resultMap.put("data", data);
		}
		/**
		 * 返回数据
		 */
		HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 200);
        resultMap.put("msg", "success");
        resultMap.put("data", data);
        
		return resultMap;		
	}

    /**
     * 根据学校名进行模糊查询
     *
     * @param schoolChar 进行模糊查询的学校部分名称
     * @return 列表形式的学校名
     */
    @Override
    public List<String> fuzzyQuerySchool(String schoolChar) {
        List<String> schoolList = new ArrayList<>();
        schoolList = schoolMapper.selectSchoolsByFuzzyQuery(schoolChar);
        return schoolList;
    }


}
