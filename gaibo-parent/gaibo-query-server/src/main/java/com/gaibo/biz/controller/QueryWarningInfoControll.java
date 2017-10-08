package com.gaibo.biz.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	public @ResponseBody String queryWarning(HttpServletRequest request){
		logger.info("进入queryWarning......");
		
		Map<String, Object> map = new HashMap<String, Object>();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		logger.info(">>>>>>>>>>>>>>>>username:"+userName+";password:"+password);
		map.put("userName", userName);
		map.put("password", password);
		
		return queryWarningInfo.queryWarning(map) ;
	}
	
}
