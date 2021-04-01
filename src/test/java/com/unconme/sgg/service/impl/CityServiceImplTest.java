/**
 * 
 */
package com.unconme.sgg.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.unconme.sgg.service.*;

import lombok.extern.slf4j.Slf4j;

import com.unconme.sgg.dao.mapper.*;
import com.unconme.sgg.entity.*;
/**
 * @author lky
 * @date Jul 6, 2020
 */
@SpringBootTest
class CityServiceImplTest {
	
	@Autowired
    private CityService cityServiceImpl;
	
	@Autowired
	private CityMapper cityMapper;
	
	@Test
	void test() {
		City london = new City();
		london.setCityId("0");
		london.setCityNameCh("伦敦");
		london.setCityNameEn("London");
		london.setCityPhotoUrl("http://api.sgg.com/city/photo?city_name=London");
		london.setClothes("伦敦天气宜人，不需要穿衣服。");
		london.setFood("伦敦经济发达，消费水平较高，一顿饭平均每人30磅。");
		london.setLife("伦敦房价一般是其他城市的两倍左右。例如格拉斯哥的学生公寓一般150-200磅每周，而伦敦的学生公寓要300-400磅每周。");
		london.setTravel("交通方便，有地铁、公交、火车、飞机等。计程车平均每公里xx元。交通开销较高。");
		london.setMapUrl("http://xxx/xxx.jpg");
		london.setIntroduction("伦敦是一座全球领先的世界级城市，是全球最富裕、经济最发达、商业最繁荣、生活水平最高的城市之一，在政治、经济、文化、教育、科技、金融、商业、体育、传媒、时尚等各方面影响着全世界，是全球化的典范。");
		
		City glasgow = new City();
		glasgow.setCityId("1");
		glasgow.setCityNameCh("格拉斯哥");
		glasgow.setCityNameEn("Glasgow");
		glasgow.setCityPhotoUrl("http://api.sgg.com/city/photo?city_name=Glasgow");
		glasgow.setClothes("xxx。");
		glasgow.setFood("xxx。");
		glasgow.setLife("xxxxx。");
		glasgow.setTravel("xxxxxxxxxxxxxx。");
		glasgow.setMapUrl("http://xxx/xxx.jpg");
		glasgow.setIntroduction("xxxxxxx。");
		

		cityMapper.insert(london);
		cityMapper.insert(glasgow);
		
		//HashMap<String, Object> cityList = cityServiceImpl.cityService(null);
		//HashMap<String, Object> cityInfo = cityServiceImpl.cityService("0");
	}

}
