package org.gaibo.common.constants;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 付款方式 暂时存放于map,后面改成数据库
 * @author 272311
 *
 */
public class PayWayMap {

	
private static final Map<String,String> payWayMap = new HashMap<String,String>();
	
	static{
		payWayMap.put("wx_pub", "微信支付");
		payWayMap.put("alipay", "支付宝");
	}
	
	public static String getPayWay(String key){
		String value = "其他" ;
		if(payWayMap.containsKey(key)){
			value = payWayMap.get(key);
		}
		return value ;
	}
	
}
