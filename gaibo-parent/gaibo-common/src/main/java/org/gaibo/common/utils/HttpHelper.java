package org.gaibo.common.utils;

import java.io.IOException;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpHelper {

	private static Logger logger = LoggerFactory.getLogger(HttpHelper.class);
	
	public static String execute(String url) {
		String response = "请求结果异常" ;
		
		try {
			HttpClient httpClient = new HttpClient();
			PostMethod postMethod = new PostMethod(url);
			postMethod.getParams().setContentCharset(CharEncoding.UTF_8);
			postMethod.getParams().setHttpElementCharset(CharEncoding.UTF_8);

			int status = httpClient.executeMethod(postMethod);
			
			if(HttpStatus.SC_OK == status){
				response = postMethod.getResponseBodyAsString() ;
				logger.info("请求返回内容 response:"+response) ;
				
			}else{
				response = postMethod.getResponseBodyAsString() ;
				logger.info("http请求异常");
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

}
