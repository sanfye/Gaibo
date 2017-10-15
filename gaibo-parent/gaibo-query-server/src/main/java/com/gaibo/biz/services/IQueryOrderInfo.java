package com.gaibo.biz.services;

import java.util.Map;

/**
 * 订单信息查询接口
 * @author sangwenhao
 * @date 2017-08-22
 */
public interface IQueryOrderInfo {
	
	String queryOrderInfo(String startTime, String endTime,Map<String,Object> map);

	String queryOrderByCurrent(Map<String,Object> map);
	
	String queryOrderBySpecify(String startTime,String endTime,Map<String,Object> map);
	
	String queryOrderByHistory( String month,Map<String,Object> map);
}
