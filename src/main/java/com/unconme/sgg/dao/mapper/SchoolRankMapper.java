package com.unconme.sgg.dao.mapper;

import com.unconme.sgg.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

public interface SchoolRankMapper extends Mapper<SchoolRank>{
    @Select("SELECT school_id FROM school_rank ORDER BY qs_rank")
    @Result(property="schoolId", column="school_id")
    public List<String> getSchoolIdByQS();

    @Select("SELECT school_id FROM school_rank ORDER BY times_rank")
    @Result(property="schoolId", column="school_id")
    public List<String> getSchoolIdByTimes();

    @Select("SELECT school_id FROM school_rank ORDER BY shangjiao_rank")
    @Result(property="schoolId", column="school_id")
    public List<String> getSchoolIdBySJ();
}
