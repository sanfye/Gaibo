package com.gaibo.biz.services.provide;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gaibo.biz.server.IUserMachineServer;

@Transactional
public class UserMachineProvideSerice {

	@Autowired
	private IUserMachineServer userMachineServer ;

	public List<String> findMachineByUser(String userName) {

		return userMachineServer.findMachineByUser(userName);
	}

	public IUserMachineServer getUserMachineServer() {
		return userMachineServer;
	}

	public void setUserMachineServer(IUserMachineServer userMachineServer) {
		this.userMachineServer = userMachineServer;
	}
	
}
