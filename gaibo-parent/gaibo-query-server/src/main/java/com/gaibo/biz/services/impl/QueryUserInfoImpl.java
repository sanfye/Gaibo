package com.gaibo.biz.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaibo.biz.server.IUserInfoService;
import com.gaibo.biz.services.IQueryUserInfo;
import com.gaibo.biz.share.vo.User;

@Service
public class QueryUserInfoImpl implements IQueryUserInfo{
	
	@Autowired
	private IUserInfoService userInfoService;
	
	@Override
	public User queryUserInfo(String name) {
		// TODO Auto-generated method stub
		return userInfoService.queryUserInfo(name);
	}

}
