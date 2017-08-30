package com.gaibo.biz.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaibo.biz.services.IQueryWarningInfo;

/**
 * 报警信息查询 入口
 * @author sangwenhao
 * @date 2017-08-22
 */
@Controller
@RequestMapping(value="/queryWarningInfo")
public class QueryWarningInfoControll {

	private static final Logger logger = LoggerFactory.getLogger(QueryWarningInfoControll.class) ;
	
	@Resource
	private IQueryWarningInfo queryWarningInfo ;
	
	@RequestMapping("/isSuccess")
	private @ResponseBody String testIsStart(){
		return "gaibo-query-server server is start success! ";
	}
	
	@RequestMapping("/warning")
	public @ResponseBody String queryWarning(){
		logger.info("进入queryWarning......");
		
		return queryWarningInfo.queryWarning() ;
	}
	
}
