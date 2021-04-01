package com.unconme.sgg.entity;

import java.util.List;

import javax.persistence.Id;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name="school")
public class School {
	@Id
	@Column(name="school_id",type=MySqlTypeConstant.VARCHAR, isKey=true)
    private String schoolId;
	
	@Column(name="city_id",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String cityId;
	
	@Column(name="ch_name",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String chName;
	
	@Column(name="en_name",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String enName;
	
	@Column(name="address",type=MySqlTypeConstant.VARCHAR)
    private String address;
	
	@Column(name="phone",type=MySqlTypeConstant.VARCHAR)
    private String phone;
	
	@Column(name="photo_url",type=MySqlTypeConstant.VARCHAR)
    private String photoUrl;
	
	@Column(name="url",type=MySqlTypeConstant.VARCHAR)
    private String url;
	
	@Column(name="apply_material",type=MySqlTypeConstant.VARCHAR)
    private String applyMaterial;
	
	@Column(name="email",type=MySqlTypeConstant.VARCHAR)
    private String email;
	
	@Column(name="open_date",type=MySqlTypeConstant.VARCHAR)
    private String openDate;
	
	@Column(name="days",type=MySqlTypeConstant.VARCHAR)
    private String days;
	
	@Column(name="required_ielts",type=MySqlTypeConstant.VARCHAR)
    private String requiredIelts;
	
	@Column(name="reject_rate",type=MySqlTypeConstant.FLOAT)
    private Float rejectRate;
	
	@Column(name="average_offer_speed",type=MySqlTypeConstant.FLOAT)
    private Float averageOfferSpeed;

	@Column(name="environment",type=MySqlTypeConstant.VARCHAR)
    private String environment;
	
	@Column(name="selected_reason",type=MySqlTypeConstant.VARCHAR)
    private String selectedReason;
	
	@Column(name="dom",type=MySqlTypeConstant.VARCHAR)
    private String dom;
	
	@Column(name="location",type=MySqlTypeConstant.VARCHAR)
    private String location;
	
	@Column(name="history",type=MySqlTypeConstant.VARCHAR)
    private String history;
	
	@Column(name="tuition_fee",type=MySqlTypeConstant.FLOAT)
    private Float tuitionFee;
	
	@Column(name="book_fee",type=MySqlTypeConstant.FLOAT)
    private Float bookFee;
	
	@Column(name="apply_fee",type=MySqlTypeConstant.FLOAT)
    private Float applyFee;
	
	@Column(name="hotel_fee",type=MySqlTypeConstant.FLOAT)
    private Float hotelFee;
	
	@Column(name="life_fee",type=MySqlTypeConstant.FLOAT)
    private Float lifeFee;
	
	// 学校雇主评分
	@Column(name="employer_rating",type=MySqlTypeConstant.VARCHAR)
    private String employerRating;
	
	// 学校发表论文数
	@Column(name="paper_num",type=MySqlTypeConstant.VARCHAR)
    private String paperNum;
	
	private City city;
	
	private SchoolRank rank;
	
	private List<Major> major;
}
