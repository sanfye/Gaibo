package com.gaibo.biz.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gaibo.biz.dao.IUserInfoDao;
import com.gaibo.biz.server.IUserInfoService;
import com.gaibo.biz.share.vo.User;

/**
 * 查询用户信息
 * @author Administrator
 *
 */
@Transactional
public class UserInfoService implements IUserInfoService{
	@Autowired
	private IUserInfoDao userInfoDao;
	
	@Override
	public User queryUserInfo(String name) {
		// TODO Auto-generated method stub
		return userInfoDao.queryUserInfo(name);
	}

}
