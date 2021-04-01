package com.unconme.sgg.entity;

import javax.persistence.Id;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name="city")
public class City {
	@Id
	@Column(name="city_id",type=MySqlTypeConstant.VARCHAR, isKey=true)
    private String cityId;

	@Column(name="city_name_ch", type=MySqlTypeConstant.VARCHAR, isNull=false)
	private String cityNameCh;
	
	@Column(name="city_name_en", type=MySqlTypeConstant.VARCHAR, isNull=false)
	private String cityNameEn;
	
	@Column(name="map_url", type=MySqlTypeConstant.VARCHAR)
	private String mapUrl;
	
	@Column(name="city_photo_url", type=MySqlTypeConstant.VARCHAR)
	private String cityPhotoUrl;
	
	@Column(name="introduction",type=MySqlTypeConstant.VARCHAR, isNull=false)
    private String introduction;
	
	@Column(name="clothes",type=MySqlTypeConstant.VARCHAR)
    private String clothes;
	
	@Column(name="food",type=MySqlTypeConstant.VARCHAR)
    private String food;
	
	@Column(name="life",type=MySqlTypeConstant.VARCHAR)
    private String life;
	
	@Column(name="travel",type=MySqlTypeConstant.VARCHAR)
    private String travel;
	
	@Column(name="gdp",type=MySqlTypeConstant.FLOAT)
    private Float gdp;
	
	//浠ヤ�璁℃��
	@Column(name="population",type=MySqlTypeConstant.FLOAT)
    private Float population;
	
	@Column(name="house_rent",type=MySqlTypeConstant.FLOAT)
    private Float houseRent;
	
	@Column(name="ipo_count",type=MySqlTypeConstant.INT)
    private Integer IpoCount;
}
