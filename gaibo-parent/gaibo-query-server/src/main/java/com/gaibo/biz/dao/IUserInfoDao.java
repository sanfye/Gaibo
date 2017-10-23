package com.gaibo.biz.dao;

import com.gaibo.biz.share.vo.User;

public interface IUserInfoDao {
	
	public User queryUserInfo(String name);
}
