package com.gaibo.biz.services;

import java.util.Map;

/**
 * 设备信息查询接口
 * @author sangwenhao
 * @date 2017-08-22
 */
public interface IQueryDeviceInfo {

	String queryDevice( String queryType,Map<String,Object> map);
}
