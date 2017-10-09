package com.gaibo.biz.server;

import java.util.List;

public interface IUserMachineServer {

	/**
	 * 根据用户信息查询机器信息
	 * @return
	 * @author sangwenhao
	 * @date 2017年10月9日
	 */
	public List<String> findMachineByUser(String userName); 
}
