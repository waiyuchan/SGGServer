package com.unconme.sgg;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.unconme.sgg.dao.mapper", "com.unconme.sgg.controller", "com.unconme.sgg.service.impl", "com.unconme.sgg.service", "com.gitee.sunchenbin.mybatis.actable.manager"})
@MapperScan({"com.unconme.sgg.service","com.unconme.sgg.dao.mapper", "com.unconme.sgg.service.impl", "com.gitee.sunchenbin.mybatis.actable.dao.**"})
public class SggApplication {

	public static void main(String[] args) {
		SpringApplication.run(SggApplication.class, args);
	}

}
