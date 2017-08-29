package com.gaibo.biz.services.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gaibo.biz.common.utils.HttpHelper;
import com.gaibo.biz.services.IQueryDeviceInfo;

@Service
public class QueryDeviceInfoImpl implements IQueryDeviceInfo {
	
	//info 返回结果正常
	private static String URL_INFO = "http://103.231.67.143:8079/DEVICE?QID=300001&QLEVEL=INFO&USERNAME=user&MAC=f9add388b2fc6ca7628deb27d3504245";
	private static String URL_SUPPLY = "http://103.231.67.143:8079/DEVICE?QID=300002&QLEVEL=SUPPLY&USERNAME=user&MAC=6ee245951220098c2c940284b8d9bdf9";
	private static String TYPE_INFO = "INFO" ;
	private static String TYPE_SUPPLY = "SUPPLY" ;
	
	private static final Logger logger = LoggerFactory.getLogger(QueryDeviceInfoImpl.class);
	
	@Override
	public String queryDevice(String queryType) {
		logger.info("进入service层-queryDevice ......");
		
		String url = URL_INFO ;
		//查询物料信息
		if(StringUtils.equalsIgnoreCase(queryType, TYPE_SUPPLY)){
			url = URL_SUPPLY ;
		}/*else if(StringUtils.equalsIgnoreCase(queryType, TYPE_INFO)){//查询机器信息
			
		}else{
			//输入参数有误
		}*/
		String response = HttpHelper.execute(url);
		
		return response ;
	}

}
