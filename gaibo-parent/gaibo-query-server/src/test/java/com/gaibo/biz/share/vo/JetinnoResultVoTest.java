package com.gaibo.biz.share.vo;

import java.util.List;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
/**
 * 
 * @author sangwenhao
 * @date 2017年9月28日
 */
public class JetinnoResultVoTest {

	private Logger logger = LoggerFactory.getLogger(JetinnoResultVoTest.class);
	
	@Test
	public void test2(){
		String s = "{\"record\":[[33318,\"cash_order\",802,0,\"cash\",\"Wed, 01 Mar 2017 10:28:44 GMT\"],[33318,\"cash_order\",921,0,\"cash\",\"Wed, 01 Mar 2017 10:29:32 GMT\"]],\"status\":\"success\"}";
		
		JSONObject json = (JSONObject) JSONObject.parse(s);
		logger.info("status:"+json.get("status"));
		JSONArray records = (JSONArray) json.get("record") ;
		for(int i=0;i<records.size();i++){
			JSONArray list = (JSONArray) records.get(i);
			for(int j=0;j<list.size();j++){
				logger.info((String) list.get(j));
			}
			
		}
//		for(List<String> list : records){
//			for(String str : records){
//				logger.info(str);
//			}
//		}
	}
	
	@Test
	public void test() {
		String s = "{\"record\":[[33318,\"cash_order\",802,0,\"cash\",\"Wed, 01 Mar 2017 10:28:44 GMT\"],[33318,\"cash_order\",921,0,\"cash\",\"Wed, 01 Mar 2017 10:29:32 GMT\"]],\"status\":\"success\"}";
		JetinnoResultVo resultVo = JSON.parseObject(s, JetinnoResultVo.class);
		List<List<String>> records = resultVo.getRecord();
		
		logger.info("status:"+resultVo.getStatus());
		
		for(List<String> list : records){
			for(String str : list){
				logger.info(str);
			}
		}
		
	}

}
