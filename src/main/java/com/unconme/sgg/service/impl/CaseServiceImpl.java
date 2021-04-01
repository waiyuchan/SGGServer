package com.unconme.sgg.service.impl;

import com.unconme.sgg.dao.mapper.*;
import com.unconme.sgg.entity.*;
import com.unconme.sgg.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Fuwei Feng
 * @version: 2020/7/6
 */
@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    private StanCaseMapper stanCaseMapper;

    @Autowired
    private SchoolMapper schoolMapper;

    @Autowired
    private SchoolRankMapper rankMapper;

    @Autowired
    private ApplicantMapper applicantMapper;

    @Autowired
    private MajorMapper majorMapper;

    /**
     * 通过案例ID来获取对应案例的信息
     *
     * @param caseId 案例ID
     * @return 对应的案例的相关信息
     */
    @Override
    public HashMap<String, Object> getCaseInstance(String caseId) {
        HashMap<String, Object> data = new HashMap<>();
        StanCase caseInstance = stanCaseMapper.selectByPrimaryKey(caseId);

        School schoolCase = schoolMapper.selectBySchoolId(caseInstance.getSchoolId());
        SchoolRank schoolRank = rankMapper.selectByPrimaryKey(schoolCase.getSchoolId());
        Applicant applicant = applicantMapper.selectByAid(caseInstance.getAid());
        Major major = majorMapper.selectByMajorId(caseInstance.getMajor());

        String case_id = caseInstance.getCaseId();
        String aid = caseInstance.getAid();
        String cnName = schoolCase.getChName();
        String enName = schoolCase.getEnName();
        String cnMajor = major.getMajorNameCh();
        String enMajor = major.getMajorNameEn();
        String admissionType = caseInstance.getDegree();
        String qsRank = schoolRank.getQsRank();
        String timesRank = schoolRank.getTimesRank();
        String majorRank = caseInstance.getMajor();
        String offerDate = caseInstance.getResultDate();
        String ugLevel = applicant.getUgNote();
        String ugGpa = applicant.getUgGpa().toString();
        String pgLevel = "";
        String pgGpa = "";
        int apRes = caseInstance.getResult();
        String applyResult = "";
        if (apRes == 1) {
            applyResult = "offer";
        } else {
            applyResult = "reject";
        }

        data.put("case_id", case_id);
        data.put("aid", aid);
        data.put("admission_school_ch", cnName);
        data.put("admission_school_en", enName);
        data.put("admission_major_ch", cnMajor);
        data.put("admission_major_en", enMajor);
        data.put("admission_type", admissionType);
        data.put("qs_rank", qsRank);
        data.put("times_rank", timesRank);
        data.put("major_rank", majorRank);
        data.put("offer_date", offerDate);
        data.put("ug_level", ugLevel);
        data.put("ug_gpa", ugGpa);
        data.put("pg_level", pgLevel);
        data.put("pg_gpa", pgGpa);
        data.put("apply_result", applyResult);

        if (data.isEmpty()) {
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("status", 500);
            resultMap.put("msg", "接口调用失败");
            resultMap.put("data", data);
            return resultMap;
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 200);
        resultMap.put("msg", "success");
        resultMap.put("data", data);

        return resultMap;
    }

    /**
     * 获取所有案例
     *
     * @return List<StanCase> 返回所有申请案例
     */
    @Override
    public HashMap<String, Object> getAllCases() {
        // 获取所有案例
        List<StanCase> casesList = stanCaseMapper.selectAllCases();
        // 通过List的形式存储所有案例信息（案例信息通过HashMap来存储）
        List<HashMap<String, Object>> data = new ArrayList<>();
        Iterator<StanCase> iterator = casesList.iterator();
        while (iterator.hasNext()) {
            // 将案例信息提取出来
            StanCase singleCase = iterator.next();
            School schoolCase = schoolMapper.selectBySchoolId(singleCase.getSchoolId());
            SchoolRank schoolRank = rankMapper.selectByPrimaryKey(schoolCase.getSchoolId());
            Applicant applicant = applicantMapper.selectByPrimaryKey(singleCase.getAid());

            String case_id = singleCase.getCaseId();
            String aid = singleCase.getAid();
            String cnName = schoolCase.getChName();
            String enName = singleCase.getSchool().getEnName();
            String cnMajor = singleCase.getMajor();
            String enMajor = singleCase.getMajor();
            String admissionType = singleCase.getDegree();
            String qsRank = schoolRank.getQsRank();
            String timesRank = schoolRank.getTimesRank();
            String majorRank = singleCase.getMajor();
            String offerDate = singleCase.getResultDate();
            String ugLevel = applicant.getUgNote();
            String ugGpa = applicant.getUgGpa().toString();
            String pgLevel = "";
            String pgGpa = "";
            int apRes = singleCase.getResult();
            String applyResult = "";
            if (apRes == 1) {
                applyResult = "offer";
            } else {
                applyResult = "reject";
            }

            // 建立HashMap来存储单个案例的信息
            HashMap<String, Object> singleCaseInfo = new HashMap<>();
            singleCaseInfo.put("case_id", case_id);
            singleCaseInfo.put("aid", aid);
            singleCaseInfo.put("admission_school_ch", cnName);
            singleCaseInfo.put("admission_school_en", enName);
            singleCaseInfo.put("admission_major_ch", cnMajor);
            singleCaseInfo.put("admission_major_en", enMajor);
            singleCaseInfo.put("admission_type", admissionType);
            singleCaseInfo.put("qs_rank", qsRank);
            singleCaseInfo.put("times_rank", timesRank);
            singleCaseInfo.put("major_rank", majorRank);
            singleCaseInfo.put("offer_date", offerDate);
            singleCaseInfo.put("ug_level", ugLevel);
            singleCaseInfo.put("ug_gpa", ugGpa);
            singleCaseInfo.put("pg_level", pgLevel);
            singleCaseInfo.put("pg_gpa", pgGpa);
            singleCaseInfo.put("apply_result", applyResult);

            data.add(singleCaseInfo);
        }

        if (data.isEmpty()) {
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("status", 500);
            resultMap.put("msg", "接口调用失败");
            resultMap.put("data", data);
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 200);
        resultMap.put("msg", "success");
        resultMap.put("data", data);


        return resultMap;
    }

    /**
     * 通过学校名获取案例
     *
     * @param schoolName 学校名
     * @return List<StanCase> 返回对应学校的申请案例
     */
    @Override
    public HashMap<String, Object> getCasesBySchool(String schoolName) {
        // 通过List的形式存储对应学校案例信息（案例信息通过HashMap来存储）
        List<HashMap<String, Object>> data = new ArrayList<>();
        // 获取对应学校名称的学校对象
        School school = new School();
        school.setChName(schoolName);
        School schoolInfo = schoolMapper.selectOne(school);
        // 如果学校对象为空，证明该学校不存在（即学校名输入有误）
        if (schoolInfo == null) {
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("status", 500);
            resultMap.put("msg", "不存在该学校");
            resultMap.put("data", data);
            return resultMap;
        }

        // 通过学校id来获取对应学校的案例
        List<StanCase> casesList = stanCaseMapper.selectBySchoolId(schoolInfo.getSchoolId());

        Iterator<StanCase> iterator = casesList.iterator();

        while (iterator.hasNext()) {
            // 将案例信息提取出来
            StanCase singleCase = iterator.next();
            School schoolCase = schoolMapper.selectBySchoolId(singleCase.getSchoolId());
            SchoolRank schoolRank = rankMapper.selectByPrimaryKey(schoolCase.getSchoolId());
            Applicant applicant = applicantMapper.selectByAid(singleCase.getAid());

            String case_id = singleCase.getCaseId();
            String aid = singleCase.getAid();
            String cnName = schoolCase.getChName();
            String enName = schoolCase.getEnName();
            String cnMajor = singleCase.getMajor();
            String enMajor = singleCase.getMajor();
            String admissionType = singleCase.getDegree();
            String qsRank = schoolRank.getQsRank();
            String timesRank = schoolRank.getTimesRank();
            String majorRank = singleCase.getMajor();
            String offerDate = singleCase.getResultDate();
            String ugLevel = applicant.getUgNote();
            String ugGpa = applicant.getUgGpa().toString();
            String pgLevel = "";
            String pgGpa = "";
            int apRes = singleCase.getResult();
            String applyResult = "";
            if (apRes == 1) {
                applyResult = "offer";
            } else {
                applyResult = "reject";
            }

            // 建立HashMap来存储单个案例的信息
            HashMap<String, Object> singleCaseInfo = new HashMap<>();
            singleCaseInfo.put("case_id", case_id);
            singleCaseInfo.put("aid", aid);
            singleCaseInfo.put("admission_school_ch", cnName);
            singleCaseInfo.put("admission_school_en", enName);
            singleCaseInfo.put("admission_major_ch", cnMajor);
            singleCaseInfo.put("admission_major_en", enMajor);
            singleCaseInfo.put("admission_type", admissionType);
            singleCaseInfo.put("qs_rank", qsRank);
            singleCaseInfo.put("times_rank", timesRank);
            singleCaseInfo.put("major_rank", majorRank);
            singleCaseInfo.put("offer_date", offerDate);
            singleCaseInfo.put("ug_level", ugLevel);
            singleCaseInfo.put("ug_gpa", ugGpa);
            singleCaseInfo.put("pg_level", pgLevel);
            singleCaseInfo.put("pg_gpa", pgGpa);
            singleCaseInfo.put("apply_result", applyResult);

            data.add(singleCaseInfo);
        }

        if (data.isEmpty()) {
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("status", 500);
            resultMap.put("msg", "接口调用失败");
            resultMap.put("data", data);
            return resultMap;
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 200);
        resultMap.put("msg", "success");
        resultMap.put("data", data);


        return resultMap;
    }

    /**
     * 通过专业名获取案例
     *
     * @param majorName 专业名
     * @return List<StanCase>  返回对应专业的申请案例
     */
    @Override
    public HashMap<String, Object> getCasesByMajor(String majorName) {
        // 通过List的形式存储对应专业案例信息（案例信息通过HashMap来存储）
        List<HashMap<String, Object>> data = new ArrayList<>();
        // 通过专业名称来获取对应专业的案例
        List<String> majorIdLists = majorMapper.selectMajorIdByMajorName(majorName);
        List<StanCase> casesList = stanCaseMapper.selectByMajorId(majorIdLists);

        Iterator<StanCase> iterator = casesList.iterator();

        while (iterator.hasNext()) {
            // 将案例信息提取出来
            StanCase singleCase = iterator.next();
            School schoolCase = schoolMapper.selectBySchoolId(singleCase.getSchoolId());
            SchoolRank schoolRank = rankMapper.selectByPrimaryKey(schoolCase.getSchoolId());
            Applicant applicant = applicantMapper.selectByAid(singleCase.getAid());
            Major major = majorMapper.selectByMajorId(singleCase.getMajor());

            String case_id = singleCase.getCaseId();
            String aid = singleCase.getAid();
            String cnName = schoolCase.getChName();
            String enName = schoolCase.getEnName();
            String cnMajor = major.getMajorNameCh();
            String enMajor = major.getMajorNameEn();
            String admissionType = singleCase.getDegree();
            String qsRank = schoolRank.getQsRank();
            String timesRank = schoolRank.getTimesRank();
            String majorRank = singleCase.getMajor();
            String offerDate = singleCase.getResultDate();
            String ugLevel = applicant.getUgNote();
            String ugGpa = applicant.getUgGpa().toString();
            String pgLevel = "";
            String pgGpa = "";
            int apRes = singleCase.getResult();
            String applyResult = "";
            if (apRes == 1) {
                applyResult = "offer";
            } else {
                applyResult = "reject";
            }

            // 建立HashMap来存储单个案例的信息
            HashMap<String, Object> singleCaseInfo = new HashMap<>();
            singleCaseInfo.put("case_id", case_id);
            singleCaseInfo.put("aid", aid);
            singleCaseInfo.put("admission_school_ch", cnName);
            singleCaseInfo.put("admission_school_en", enName);
            singleCaseInfo.put("admission_major_ch", cnMajor);
            singleCaseInfo.put("admission_major_en", enMajor);
            singleCaseInfo.put("admission_type", admissionType);
            singleCaseInfo.put("qs_rank", qsRank);
            singleCaseInfo.put("times_rank", timesRank);
            singleCaseInfo.put("major_rank", majorRank);
            singleCaseInfo.put("offer_date", offerDate);
            singleCaseInfo.put("ug_level", ugLevel);
            singleCaseInfo.put("ug_gpa", ugGpa);
            singleCaseInfo.put("pg_level", pgLevel);
            singleCaseInfo.put("pg_gpa", pgGpa);
            singleCaseInfo.put("apply_result", applyResult);

            data.add(singleCaseInfo);
        }

        if (data.isEmpty()) {
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("status", 500);
            resultMap.put("msg", "接口调用失败");
            resultMap.put("data", data);
            return resultMap;
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 200);
        resultMap.put("msg", "success");
        resultMap.put("data", data);


        return resultMap;
    }

    /**
     * 通过学校名和专业名来获取案例
     *
     * @param schoolName 学校名
     * @param majorName  专业名
     * @return List<StanCase>  返回对应学校对应专业的申请案例
     */
    @Override
    public HashMap<String, Object> getCases(String schoolName, String majorName) {
        // 通过List的形式存储对应学校以及对应专业案例信息（案例信息通过HashMap来存储）
        List<HashMap<String, Object>> data = new ArrayList<>();
        // 获取对应学校名称的学校对象
        School school = new School();
        school.setChName(schoolName);
        School schoolInfo = schoolMapper.selectOne(school);
        // 如果学校对象为空，证明该学校不存在（即学校名输入有误）
        if (schoolInfo == null) {
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("status", 500);
            resultMap.put("msg", "不存在该学校");
            resultMap.put("data", data);
            return resultMap;
        }

        // 通过学校id以及专业名来获取对应学校的案例
        Major majorcase = majorMapper.selectBySchoolIdAndMajorCnName(schoolInfo.getSchoolId(), majorName);
        List<StanCase> casesList = stanCaseMapper.selectBySchoolIdAndMajor(schoolInfo.getSchoolId(), majorcase.getMajorId());

        Iterator<StanCase> iterator = casesList.iterator();

        while (iterator.hasNext()) {
            // 将案例信息提取出来
            StanCase singleCase = iterator.next();
            School schoolCase = schoolMapper.selectBySchoolId(singleCase.getSchoolId());
            SchoolRank schoolRank = rankMapper.selectByPrimaryKey(schoolCase.getSchoolId());
            Applicant applicant = applicantMapper.selectByAid(singleCase.getAid());

            String case_id = singleCase.getCaseId();
            String aid = singleCase.getAid();
            String cnName = schoolCase.getChName();
            String enName = schoolCase.getEnName();
            String cnMajor = majorcase.getMajorNameCh();
            String enMajor = majorcase.getMajorNameEn();
            String admissionType = singleCase.getDegree();
            String qsRank = schoolRank.getQsRank();
            String timesRank = schoolRank.getTimesRank();
            String majorRank = majorcase.getRank();
            String offerDate = singleCase.getResultDate();
            String ugLevel = applicant.getUgNote();
            String ugGpa = applicant.getUgGpa().toString();
            String pgLevel = "";
            String pgGpa = "";
            int apRes = singleCase.getResult();
            String applyResult = "";
            if (apRes == 1) {
                applyResult = "offer";
            } else {
                applyResult = "reject";
            }

            // 建立HashMap来存储单个案例的信息
            HashMap<String, Object> singleCaseInfo = new HashMap<>();
            singleCaseInfo.put("case_id", case_id);
            singleCaseInfo.put("aid", aid);
            singleCaseInfo.put("admission_school_ch", cnName);
            singleCaseInfo.put("admission_school_en", enName);
            singleCaseInfo.put("admission_major_ch", cnMajor);
            singleCaseInfo.put("admission_major_en", enMajor);
            singleCaseInfo.put("admission_type", admissionType);
            singleCaseInfo.put("qs_rank", qsRank);
            singleCaseInfo.put("times_rank", timesRank);
            singleCaseInfo.put("major_rank", majorRank);
            singleCaseInfo.put("offer_date", offerDate);
            singleCaseInfo.put("ug_level", ugLevel);
            singleCaseInfo.put("ug_gpa", ugGpa);
            singleCaseInfo.put("pg_level", pgLevel);
            singleCaseInfo.put("pg_gpa", pgGpa);
            singleCaseInfo.put("apply_result", applyResult);

            data.add(singleCaseInfo);
        }

        if (data.isEmpty()) {
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("status", 500);
            resultMap.put("msg", "接口调用失败");
            resultMap.put("data", data);
            return resultMap;
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("status", 200);
        resultMap.put("msg", "success");
        resultMap.put("data", data);


        return resultMap;
    }
}
