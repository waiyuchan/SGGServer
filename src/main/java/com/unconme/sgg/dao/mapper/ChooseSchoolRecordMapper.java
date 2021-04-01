package com.unconme.sgg.dao.mapper;

import com.unconme.sgg.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

public interface ChooseSchoolRecordMapper extends Mapper<ChooseSchoolRecord> {
    @Select("SELECT * FROM choose_school_record WHERE open_id=#{open_id}")
    @Results(id = "chooseSchoolRecordMap", value = {
            @Result(property = "recordId", column = "record_id"),
            @Result(property = "schoolName", column = "school_name"),
            @Result(property = "openId", column = "open_id"),
            @Result(property = "chooseDate", column = "choose_date"),
            @Result(property = "schoolLevel", column = "school_level")
    })
    public List<ChooseSchoolRecord> selectByOpenId(@Param("open_id") String openId);
}
