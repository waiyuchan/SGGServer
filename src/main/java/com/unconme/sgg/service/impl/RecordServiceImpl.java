package com.unconme.sgg.service.impl;

import com.unconme.sgg.dao.mapper.ChooseSchoolRecordMapper;
import com.unconme.sgg.entity.ChooseSchoolRecord;
import com.unconme.sgg.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Fuwei Feng
 * @version: 2020/8/3
 */
@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private ChooseSchoolRecordMapper chooseSchoolRecordMapper;

    @Override
    public HashMap<String, Object> getSchoolRecord(String openId) {
        HashMap<String, Object> data = new HashMap<>();
        List<ChooseSchoolRecord> recordsList = chooseSchoolRecordMapper.selectByOpenId(openId);
        ArrayList<String> topSchools = new ArrayList<>();
        ArrayList<String> midSchools = new ArrayList<>();
        ArrayList<String> lastSchools = new ArrayList<>();
        Iterator<ChooseSchoolRecord> iterator = recordsList.iterator();
        while (iterator.hasNext()) {
            ChooseSchoolRecord schoolRecord = iterator.next();
            if (schoolRecord.getSchoolLevel().equals("top")) {
                topSchools.add(schoolRecord.getSchoolName());
            }
            if (schoolRecord.getSchoolLevel().equals("mid")) {
                midSchools.add(schoolRecord.getSchoolName());
            }
            if (schoolRecord.getSchoolLevel().equals("last")) {
                lastSchools.add(schoolRecord.getSchoolName());
            }
        }
        data.put("top_schools", topSchools);
        data.put("mid_schools", midSchools);
        data.put("last_schools", lastSchools);

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 200);
        resultMap.put("msg", "success");
        resultMap.put("data", data);
        return resultMap;
    }
}
