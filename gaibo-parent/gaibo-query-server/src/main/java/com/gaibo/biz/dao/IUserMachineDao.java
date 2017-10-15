package com.gaibo.biz.dao;

import java.util.List;

/**
 * 机器用户信息
 * @author sangwenhao
 * @date 2017年10月9日
 */
public interface IUserMachineDao {

	/**
	 * 根据用户信息查询机器信息
	 * @return
	 * @author sangwenhao
	 * @date 2017年10月9日
	 */
	public List<String> findMachineByUser(String userName); 
}
