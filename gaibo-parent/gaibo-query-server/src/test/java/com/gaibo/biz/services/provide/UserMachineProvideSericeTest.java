package com.gaibo.biz.services.provide;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMachineProvideSericeTest {


	//加载spring配置文件
	private ApplicationContext ac = null ;
	
	@Autowired
	private UserMachineProvideSerice userMachineProvideSerice ;
	
	private static final Logger logger = LoggerFactory.getLogger(UserMachineProvideSerice.class);


	@Before
	public void setUp() throws Exception {
		try {
			ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
//			userDao = ac.getBean(UserDao.class);
			//根据spring配置bean的名字进行查找
			userMachineProvideSerice = (UserMachineProvideSerice) ac.getBean("userMachineProvideSerice");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindMachineByUser() {
		List<String> machines = userMachineProvideSerice.findMachineByUser("zhh_sub2");
		
		if(machines!=null){
			for(String str : machines){
				logger.info("str:"+str);
			}
		}
		
	}

}
