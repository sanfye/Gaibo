package com.gaibo.biz.services.impl;

import org.apache.commons.lang3.RandomUtils;
import org.gaibo.common.constants.GaiboConstant;
import org.gaibo.common.utils.HttpHelper;
import org.gaibo.common.utils.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gaibo.biz.services.IQueryOrderInfo;

@Service
public class QueryOrderInfoImpl implements IQueryOrderInfo {

	private static final Logger logger = LoggerFactory.getLogger(QueryOrderInfoImpl.class);

	// QID：000001~999999 随机数， 6 位长度，这里去100000~199999的随机数
	int QID = RandomUtils.nextInt(100000, 199999);

	String url = GaiboConstant.URL + "/" + GaiboConstant.URI_QUERY + "?";
	
	@Override
	public String queryOrderInfo(String startTime, String endTime){
		logger.info("进入service层-queryOrderInfo ......");
		
		
	}

	@Override
	public String queryOrderByCurrent() {
		logger.info("进入service层-queryOrderByCurrent ......");

		// md5校验顺序：QID=100001&USERNAME=user&PASSWORD=password&QLEVEL=CURRENTT
		StringBuilder uri = new StringBuilder("QID=").append(QID)
				.append("&USERNAME=").append(GaiboConstant.USERNAME)
				.append("&PASSWORD=").append(GaiboConstant.PASSWORD)
				.append("&QLEVEL=CURRENT");

		String mac = MD5Utils.getMD5HEX(uri.toString());
		
		uri.append("&MAC=").append(mac) ;

		logger.info(" >>>>>>>>>>>>>>>>uri:{}",  uri);

		String response = HttpHelper.execute(url +uri);
		return response;
	}

	@Override
	public String queryOrderBySpecify(String startTime, String endTime) {
		logger.info("进入service层-queryOrderBySpecify ......");

		// QID=100002&QLEVEL=SPECIFY&STARTTIME=20170329000000&ENDTIME=20170329235959&USERNAME=user&MAC=167f80431828fbed670dfa6a7e715b5e
		// md5校验顺序：QID=100002&USERNAME=user&PASSWORD=password&QLEVEL=SPECIFY
		StringBuilder uri = new StringBuilder("QID=").append(QID)
				.append("&USERNAME=").append(GaiboConstant.USERNAME)
				.append("&PASSWORD=").append(GaiboConstant.PASSWORD)
				.append("&QLEVEL=SPECIFY");

		String mac = MD5Utils.getMD5HEX(uri.toString());

		uri.append("&MAC=").append(mac) ;

		logger.info(" >>>>>>>>>>>>>>>>uri:{}",  uri);

		String response = HttpHelper.execute(url +uri);
		return response;
	}

	@Override
	public String queryOrderByHistory(String month) {
		logger.info("进入service层-queryOrderByHistory ......");
		// QID=100003&QLEVEL=HISTORY&USERNAME=user&MONTH=201702&MAC=33a0fd9aa421b45aaafc4a0f39398109

		// uri路径不能随意拼接
		// md5校验顺序：QID=100003&USERNAME=user&PASSWORD=password&QLEVEL=HISTORY&MONTH=201702
		StringBuilder uri = new StringBuilder("QID=").append(QID)
				.append("&USERNAME=").append(GaiboConstant.USERNAME)
				.append("&PASSWORD=").append(GaiboConstant.PASSWORD)
				.append("&QLEVEL=HISTORY&MONTH=").append(month);

		String mac = MD5Utils.getMD5HEX(uri.toString());

		uri.append("&MAC=").append(mac) ;

		logger.info(" >>>>>>>>>>>>>>>>uri:{}",  uri);

		String response = HttpHelper.execute(url +uri);

		return response;
	}

}
