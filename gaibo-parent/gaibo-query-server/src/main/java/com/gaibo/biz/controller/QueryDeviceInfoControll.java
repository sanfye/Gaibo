package com.gaibo.biz.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaibo.biz.services.IQueryDeviceInfo;

/**
 * 设备信息查询 入口
 * @author sangwenhao
 * @date 2017-08-22
 */
@RestController
@RequestMapping(value="/queryDeviceInfo")
public class QueryDeviceInfoControll {

	private static final Logger logger = LoggerFactory.getLogger(QueryDeviceInfoControll.class) ;
	
	@Resource
	private IQueryDeviceInfo queryDeviceInfo ;
	
	
	@RequestMapping("/isSuccess")
	private String testIsStart(){
		logger.info("gaibo-query-server server is start success! ");
		return "gaibo-query-server server is start success! ";
	}
	
	@RequestMapping("/device/{queryType}")
	public @ResponseBody String queryDevice(@PathVariable String queryType){
		logger.info("进入queryDevice......\n >>>>>>>>>>>>>>>>queryType:{}",queryType);
		
		return queryDeviceInfo.queryDevice(queryType); 
	}
	
}
