package com.gaibo.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class GaiboQueryServerApplication extends SpringBootServletInitializer{
	
	/**
	 * 需要在打包成war包运行时，需要放开此注释
	 * @param args
	 * @author sangwenhao
	 * @date 2017年9月15日
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(GaiboQueryServerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(GaiboQueryServerApplication.class, args);
	}
}
