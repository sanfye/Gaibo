package com.gaibo.biz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单信息查询 入口
 * @author sangwenhao
 * @date 2017-08-22
 */
@EnableAutoConfiguration
@RestController
@RequestMapping(value="/queryOrderInfo")
public class QueryOrderInfoControll {

	private static final Logger logger = LoggerFactory.getLogger(QueryOrderInfoControll.class) ;
	
	@RequestMapping("/isSuccess")
	private String testIsStart(){
		return "gaibo-query-server server is start success! ";
	}

}
