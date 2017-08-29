package com.gaibo.biz.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gaibo.biz.common.utils.HttpHelper;
import com.gaibo.biz.common.utils.MD5Utils;
import com.gaibo.biz.services.IQueryOrderInfo;

@Service
public class QueryOrderInfoImpl implements IQueryOrderInfo {

	private static final Logger logger = LoggerFactory.getLogger(QueryOrderInfoImpl.class);
	
	@Override
	public String queryOrderByCurrent() {
		logger.info("进入service层-queryOrderByCurrent ......");
		
		//QID=100001&QLEVEL=CURRENT&USERNAME=user&MAC=2505a8014934fa5b25221daba2e97b07
		String url = "http://103.231.67.143:8079/QUERY?";
		
		String mac_original = "QID=100001&USERNAME=user&PASSWORD=password&QLEVEL=CURRENT";
		String mac = MD5Utils.getMD5HEX(mac_original);
		
		logger.info("mac_original:{},生成mac值：{}",mac_original,mac);
		
		url = url+mac_original+"&MAC="+mac ;
		
		String response = HttpHelper.execute(url);
		return response;
	}

	@Override
	public String queryOrderBySpecify(String startTime, String endTime) {
		logger.info("进入service层-queryOrderBySpecify ......");
		
		//QID=100002&QLEVEL=SPECIFY&STARTTIME=20170329000000&ENDTIME=20170329235959&USERNAME=user&MAC=167f80431828fbed670dfa6a7e715b5e
		String url = "http://103.231.67.143:8079/QUERY?";
		
		String mac_original = "QID=100002&USERNAME=user&PASSWORD=password&QLEVEL=SPECIFY";
		String mac = MD5Utils.getMD5HEX(mac_original);
		
		logger.info("mac_original:{},生成mac值：{}",mac_original,mac);
		
		url = url+mac_original+"&MAC="+mac ;
		
		String response = HttpHelper.execute(url);
		return response;
	}

	@Override
	public String queryOrderByHistory(String month) {
		logger.info("进入service层-queryOrderByHistory ......");
		//QID=100003&QLEVEL=HISTORY&USERNAME=user&MONTH=201702&MAC=33a0fd9aa421b45aaafc4a0f39398109
		String url = "http://103.231.67.143:8079/QUERY?";

		//uri路径不能随意拼接
		String mac_original = "QID=100003&USERNAME=user&PASSWORD=password&QLEVEL=HISTORY&MONTH=201703";
		String mac = MD5Utils.getMD5HEX(mac_original);
		
		logger.info("mac_original:{},生成mac值：{}",mac_original,mac);
		
		//uri路径随意拼接成功
		url = url+mac_original+"&MAC="+mac ;
		
		String response = HttpHelper.execute(url);
		return response;
	}

}
