package com.gaibo.biz.services;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * 设备信息查询接口
 * @author sangwenhao
 * @date 2017-08-22
 */
public interface IQueryDeviceInfo {

	String queryDevice( String queryType);
}
