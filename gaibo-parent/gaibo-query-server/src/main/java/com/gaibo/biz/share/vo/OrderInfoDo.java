package com.gaibo.biz.share.vo;

import java.util.Date;

/**
 * 
 * @author sangwenhao
 *
 */
public class OrderInfoDo {
	/**
	 * 机器编码
	 */
	private String machineNo ;
	/**
	 * 订单号
	 */
	private String orderNo ;
	/**
	 * 产品编码
	 */
	private String productCode ;
	/**
	 * 产品名称
	 */
	private String productName ;
	
	/**
	 * 金额
	 */
	private String price ;
	/**
	 * 付款方式
	 */
	private String payWay ;
	/**
	 * 订单日期
	 */
	private String orderTime ;
	
	public String getMachineNo() {
		return machineNo;
	}
	public void setMachineNo(String machineNo) {
		this.machineNo = machineNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPayWay() {
		return payWay;
	}
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	
}
