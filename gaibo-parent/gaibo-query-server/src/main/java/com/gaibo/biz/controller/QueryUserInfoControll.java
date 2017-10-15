package com.gaibo.biz.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.gaibo.biz.services.IQueryUserInfo;
import com.gaibo.biz.share.vo.User;
/**
 * 用户信息入口
 * @author Administrator
 *
 */
@RestController
@RequestMapping(value="/queryUserInfo")
public class QueryUserInfoControll {
	
	private static final Logger logger = LoggerFactory.getLogger(QueryUserInfoControll.class);
	
	@Autowired
	private IQueryUserInfo queryUserInfo;
	
	@RequestMapping(value="/userInfo")
	public String queryUserInfo(HttpServletRequest request){
		
		String userName = request.getParameter("userName");
		User user =null;
		if(StringUtils.isNotEmpty(userName)){
			user = queryUserInfo.queryUserInfo(userName);
		}
		if(user != null){
			String result = JSON.toJSONString(user) ;
			return result;
		}
		return null;
		
	}
}
