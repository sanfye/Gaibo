package com.gaibo.biz.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private String testIsStart(HttpServletRequest request){
		logger.info("gaibo-query-server server is start success! ");
		String username = request.getParameter("userName");
		logger.info(">>>>>>>>>>>>>>>>username:"+username);
		return "gaibo-query-server server is start success! ";
	}
	
	@RequestMapping("/device/{queryType}")
	public @ResponseBody String queryDevice(@PathVariable String queryType,HttpServletRequest request){
		logger.info("进入queryDevice......\n >>>>>>>>>>>>>>>>queryType:{}",queryType);
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		logger.info(">>>>>>>>>>>>>>>>username:"+userName+";password:"+password);
		map.put("userName", userName);
		map.put("password", password);
		return queryDeviceInfo.queryDevice(queryType,map); 
	}
	
}
