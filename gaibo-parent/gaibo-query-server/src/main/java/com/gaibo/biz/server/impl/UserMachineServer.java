package com.gaibo.biz.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gaibo.biz.dao.IUserMachineDao;
import com.gaibo.biz.server.IUserMachineServer;

@Transactional
public class UserMachineServer implements IUserMachineServer {

	@Autowired
	private IUserMachineDao userMachineDao ;
	
	@Override
	public List<String> findMachineByUser(String userName) {

		
		return userMachineDao.findMachineByUser(userName);
	}

}
