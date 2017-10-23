package com.gaibo.biz.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gaibo.biz.dao.IWarningDao;
import com.gaibo.biz.server.IWarningServer;
import com.gaibo.biz.share.vo.WarningFromDb;

@Transactional
public class WarningServer implements IWarningServer{
	@Autowired
     private IWarningDao warningDao;
	
	@Override
	public List<WarningFromDb> queryWarning() {
		// TODO Auto-generated method stub
		
		return warningDao.queryWarning();
	}

}
