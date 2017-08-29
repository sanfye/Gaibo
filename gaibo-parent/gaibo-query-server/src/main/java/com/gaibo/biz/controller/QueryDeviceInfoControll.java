package com.gaibo.biz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 设备信息查询 入口
 * @author sangwenhao
 * @date 2017-08-22
 */
@EnableAutoConfiguration
@RestController
@RequestMapping(value="/queryDeviceInfo")
public class QueryDeviceInfoControll {


	private static final Logger logger = LoggerFactory.getLogger(QueryDeviceInfoControll.class) ;
	
	@RequestMapping("/isSuccess")
	private String testIsStart(){
		return "gaibo-query-server server is start success! ";
	}
}
