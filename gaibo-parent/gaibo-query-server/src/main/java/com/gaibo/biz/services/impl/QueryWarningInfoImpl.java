package com.gaibo.biz.services.impl;

import java.util.Map;

import org.apache.commons.lang3.RandomUtils;
import org.gaibo.common.constants.GaiboConstant;
import org.gaibo.common.utils.HttpHelper;
import org.gaibo.common.utils.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gaibo.biz.services.IQueryWarningInfo;

@Service
public class QueryWarningInfoImpl implements IQueryWarningInfo {

	private static Logger logger = LoggerFactory.getLogger(QueryWarningInfoImpl.class);
	
//	http://103.231.67.143:8079/WARNING?QID=200001&QLEVEL=WARNING&USERNAME=user&MAC=081fa7a80661901dcb6051eaf0cfbfb6

	String url = GaiboConstant.URL + "/" + GaiboConstant.URI_WARNING + "?" ;
	
	//QID：000001~999999 随机数， 6 位长度，这里去200000~299999的随机数
	int QID= RandomUtils.nextInt(200000, 299999);
	
	/**
	 * 查询报警信息
	 * @author sangwenhao
	 * @date 2017年8月31日
	 * @see com.gaibo.biz.services.IQueryWarningInfo#queryWarning()
	 */
	@Override
	public String queryWarning(Map<String,Object> map) {
		logger.info("进入service层-queryOrderByCurrent ......");
		//用户名
		String userName = (String) map.get("userName");
		//密码
		String password = (String) map.get("password");
		
		//md5校验顺序：QID=200001&USERNAME=user&PASSWORD=password&QLEVEL=WARNING
		StringBuilder uri = new StringBuilder("QID=").append(QID)
			.append("&USERNAME=").append(GaiboConstant.USERNAME)
			.append("&PASSWORD=").append(GaiboConstant.PASSWORD)
			.append("&QLEVEL=WARNING");
		
		//生成md5校验值
		String mac = MD5Utils.getMD5HEX(uri.toString());

		uri.append("&MAC=").append(mac) ;
		url = url +uri.toString().replace("&PASSWORD="+GaiboConstant.PASSWORD, "") ;
		logger.info(" >>>>>>>>>>>>>>>>url:{}",  url);

		String response = HttpHelper.execute(url);
		return response;
	}

}
