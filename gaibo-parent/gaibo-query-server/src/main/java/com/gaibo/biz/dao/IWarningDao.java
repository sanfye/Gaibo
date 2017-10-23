package com.gaibo.biz.dao;

import java.util.List;

import com.gaibo.biz.share.vo.WarningFromDb;

public interface IWarningDao {
	public List<WarningFromDb> queryWarning();
}
