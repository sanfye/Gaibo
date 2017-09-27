package com.gaibo.biz.share.vo;

import java.util.List;

/**
 * 
 * @author sangwenhao
 * @date 2017年9月28日
 */
public class ResultVo {

	private String isError = "false" ;
	private String message = "" ;
	private String errorInfo = "" ;
	
	private List<OrderInfoVo> orderInfoVos;
	
	public String getIsError() {
		return isError;
	}
	public void setIsError(String isError) {
		this.isError = isError;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<OrderInfoVo> getOrderInfoVos() {
		return orderInfoVos;
	}
	public void setOrderInfoVos(List<OrderInfoVo> orderInfoVos) {
		this.orderInfoVos = orderInfoVos;
	}
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	
}
