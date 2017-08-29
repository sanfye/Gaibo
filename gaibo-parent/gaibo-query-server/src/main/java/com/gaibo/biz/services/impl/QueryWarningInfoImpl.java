package com.gaibo.biz.services.impl;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.math.util.MathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gaibo.biz.common.utils.HttpHelper;
import com.gaibo.biz.common.utils.MD5Utils;
import com.gaibo.biz.services.IQueryWarningInfo;

@Service
public class QueryWarningInfoImpl implements IQueryWarningInfo {

	private static Logger logger = LoggerFactory.getLogger(QueryWarningInfoImpl.class);
	
	@Override
	public String queryWarning() {
		logger.info("进入service层-queryOrderByCurrent ......");
		
		//QID=200001&QLEVEL=WARNING&USERNAME=user&MAC=081fa7a80661901dcb6051eaf0cfbfb6
		String url = "http://103.231.67.143:8079/WARNING?";
		//md5校验
		//QID=200001&USERNAME=user&PASSWORD=password&QLEVEL=WARNING
		String mac_original = "QID=200002&USERNAME=user&PASSWORD=password&QLEVEL=WARNING";
		String mac = MD5Utils.getMD5HEX(mac_original);
		logger.info("mac_original:{},生成mac值：{}",mac_original,mac);
		
		url = url+mac_original+"&MAC="+mac ;
		
		String response = HttpHelper.execute(url);
		return response;
	}

}
