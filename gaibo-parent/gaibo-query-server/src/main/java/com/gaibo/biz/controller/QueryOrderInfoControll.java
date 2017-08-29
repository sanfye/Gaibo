package com.gaibo.biz.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaibo.biz.services.IQueryOrderInfo;

/**
 * 订单信息查询 入口
 * @author sangwenhao
 * @date 2017-08-22
 */
@RestController
@RequestMapping(value="/queryOrderInfo")
public class QueryOrderInfoControll {

	private static final Logger logger = LoggerFactory.getLogger(QueryOrderInfoControll.class) ;
	
	@Resource
	private IQueryOrderInfo queryOrderInfo ;
	
	@RequestMapping("/isSuccess")
	private String testIsStart(){
		logger.info("gaibo-query-server server is start success! ");
		return "gaibo-query-server server is start success! ";
	}
	
	@RequestMapping(value="/current")
	public String queryOrderByCurrent(){
		logger.info("进入 queryOrderByCurrent...... ");
		
		queryOrderInfo.queryOrderByCurrent();
		
		return queryOrderInfo.queryOrderByCurrent();
	}
	
	@RequestMapping(value="/specify")
	public String queryOrderBySpecify(@RequestParam(value="startTime") String startTime,@RequestParam(value="endTime") String endTime){
		logger.info("进入 queryOrderBySpecify......\n >>>>>>>>>>>>>>>>startTime:{},endTime:{}",startTime,endTime);
		
		queryOrderInfo.queryOrderBySpecify(startTime, endTime);
		
		return queryOrderInfo.queryOrderBySpecify(startTime, endTime);
	}
	
	@RequestMapping(value="/history/{month}")
	public String queryOrderByHistory(@PathVariable String month){
		logger.info("进入 queryOrderByHistory......\n >>>>>>>>>>>>>>>>month:{}",month);
		
		queryOrderInfo.queryOrderByHistory(month);
		
		
		return queryOrderInfo.queryOrderByHistory(month);
	}

}
