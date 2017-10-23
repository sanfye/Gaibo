package com.gaibo.biz.server;

import java.util.List;

import com.gaibo.biz.share.vo.WarningFromDb;

public interface IWarningServer {
	public List<WarningFromDb> queryWarning();
}
