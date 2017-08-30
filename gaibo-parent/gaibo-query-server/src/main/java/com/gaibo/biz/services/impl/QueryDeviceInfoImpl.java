package com.gaibo.biz.services.impl;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.gaibo.common.constants.GaiboConstant;
import org.gaibo.common.utils.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gaibo.biz.common.utils.HttpHelper;
import com.gaibo.biz.services.IQueryDeviceInfo;

@Service
public class QueryDeviceInfoImpl implements IQueryDeviceInfo {
	
//	http://103.231.67.143:8079/DEVICE?QID=300001&QLEVEL=INFO&USERNAME=user&MAC=f9add388b2fc6ca7628deb27d3504245
	private static String TYPE_INFO = "INFO" ;
	private static String TYPE_SUPPLY = "SUPPLY" ;
	
	private static final Logger logger = LoggerFactory.getLogger(QueryDeviceInfoImpl.class);
	
	String url = GaiboConstant.URL+"/"+GaiboConstant.URI_DEVICE+"?";
	
	//QID：000001~999999 随机数， 6 位长度，这里去300000~399999的随机数
	int QID= RandomUtils.nextInt(300000, 399999);
	/**
	 * 查询设备信息
	 * @param queryType:INFO 查询机器信息；queryType:SUPPLY 查询机器物料状态
	 * @author sangwenhao
	 * @date 2017年8月30日
	 */
	@Override
	public String queryDevice(String queryType) {
		logger.info("进入service层-queryDevice ......");
		
		//md5校验顺序：QID=300001&USERNAME=user&PASSWORD=password&QLEVEL=INFO
		StringBuilder uri = new StringBuilder("QID=").append(QID)
			.append("&USERNAME=").append(GaiboConstant.USERNAME)
			.append("&PASSWORD=").append(GaiboConstant.PASSWORD);
			
		//查询物料信息
		if(StringUtils.equalsIgnoreCase(queryType, TYPE_SUPPLY)){
			uri.append("&QLEVEL=SUPPLY"); 
			
		}else if(StringUtils.equalsIgnoreCase(queryType, TYPE_INFO)){//查询机器信息
			uri.append("&QLEVEL=INFO"); 
			
		}else{
			//输入参数有误
		}

		String mac = MD5Utils.getMD5HEX(uri.toString());

		uri.append("&MAC=").append(mac) ;

		logger.info(" >>>>>>>>>>>>>>>>uri:{}",  uri);

		String response = HttpHelper.execute(url +uri);
		
		return response ;
	}

}
