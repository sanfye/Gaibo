package com.gaibo.biz.services;

/**
 * 订单信息查询接口
 * @author sangwenhao
 * @date 2017-08-22
 */
public interface IQueryOrderInfo {

	String queryOrderByCurrent();
	
	String queryOrderBySpecify(String startTime,String endTime);
	
	String queryOrderByHistory( String month);
}
