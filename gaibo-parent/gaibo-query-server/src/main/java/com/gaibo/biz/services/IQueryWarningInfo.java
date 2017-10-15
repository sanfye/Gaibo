package com.gaibo.biz.services;

import java.util.Map;

/**
 * 报警信息查询接口
 * @author sangwenhao
 * @date 2017-08-22
 */
public interface IQueryWarningInfo {

	String queryWarning(Map<String,Object> map);
}
