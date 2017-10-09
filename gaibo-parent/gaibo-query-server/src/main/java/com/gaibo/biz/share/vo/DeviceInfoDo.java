package com.gaibo.biz.share.vo;

public class DeviceInfoDo {

	/**
	 * 机器编码
	 */
	private String machineNo ;
	
	/**
	 * 位置简述
	 */
	private String siteSimple ;
	
	/**
	 * 详细地址
	 */
	private String siteDetail ;
	
	/**
	 * 联网状态 1:联网 ；0：断网
	 */
	private int onOffLine ;

	public String getMachineNo() {
		return machineNo;
	}

	public void setMachineNo(String machineNo) {
		this.machineNo = machineNo;
	}

	public String getSiteSimple() {
		return siteSimple;
	}

	public void setSiteSimple(String siteSimple) {
		this.siteSimple = siteSimple;
	}

	public String getSiteDetail() {
		return siteDetail;
	}

	public void setSiteDetail(String siteDetail) {
		this.siteDetail = siteDetail;
	}

	public int getOnOffLine() {
		return onOffLine;
	}

	public void setOnOffLine(int onOffLine) {
		this.onOffLine = onOffLine;
	}
	
}
