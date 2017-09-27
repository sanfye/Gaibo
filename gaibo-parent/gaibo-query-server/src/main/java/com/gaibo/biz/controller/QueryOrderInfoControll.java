package com.gaibo.biz.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		return queryOrderInfo.queryOrderByCurrent();
	}
	
	@RequestMapping(value="/orderInfo",method = {RequestMethod.GET,RequestMethod.POST})
	public String queryOrderInfo(@RequestParam(value="startTime") String startTime,@RequestParam(value="endTime") String endTime){
		logger.info("进入 queryOrderInfo......\n >>>>>>>>>>>>>>>>startTime:{},endTime:{}",startTime,endTime);
		Date date = new Date();
		//冗余代码
		if(StringUtils.isBlank(startTime)||StringUtils.isBlank(endTime)){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			startTime =simpleDateFormat.format(DateUtils.addDays(date, -1)) ;
			endTime = simpleDateFormat.format(date) ;
		}
		String json = queryOrderInfo.queryOrderInfo(startTime, endTime) ;
		logger.info("返回结果："+json);
		return json ;
	}
	
	
	@RequestMapping(value="/specify")
	public String queryOrderBySpecify(@RequestParam(value="startTime") String startTime,@RequestParam(value="endTime") String endTime){
		logger.info("进入 queryOrderBySpecify......\n >>>>>>>>>>>>>>>>startTime:{},endTime:{}",startTime,endTime);
		//冗余代码
		if(StringUtils.isBlank(startTime)||StringUtils.isBlank(endTime)){
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			startTime =simpleDateFormat.format(DateUtils.addDays(date, -1)) ;
			endTime = simpleDateFormat.format(date) ;
		}
		
		return queryOrderInfo.queryOrderBySpecify(startTime, endTime);
	}
	
	@RequestMapping(value="/history/{month}")
	public String queryOrderByHistory(@PathVariable String month){
		logger.info("进入 queryOrderByHistory......\n >>>>>>>>>>>>>>>>month:{}",month);
		
		//冗余代码
		if(StringUtils.isBlank(month)){
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
			month = simpleDateFormat.format(date) ;
		}
		
		return queryOrderInfo.queryOrderByHistory(month);
	}

}
