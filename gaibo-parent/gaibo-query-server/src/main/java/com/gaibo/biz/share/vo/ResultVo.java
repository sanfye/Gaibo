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
	
	/**
	 * 订单信息
	 */
	private List<OrderInfoDo> orderInfoVos = null ;
	
	/**
	 * Device-Info 机器信息
	 */
	private List<DeviceInfoDo> deviceInfoDos = null ;
	
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
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	public List<OrderInfoDo> getOrderInfoVos() {
		return orderInfoVos;
	}
	public void setOrderInfoVos(List<OrderInfoDo> orderInfoVos) {
		this.orderInfoVos = orderInfoVos;
	}
	public List<DeviceInfoDo> getDeviceInfoDos() {
		return deviceInfoDos;
	}
	public void setDeviceInfoDos(List<DeviceInfoDo> deviceInfoDos) {
		this.deviceInfoDos = deviceInfoDos;
	}
	
}
