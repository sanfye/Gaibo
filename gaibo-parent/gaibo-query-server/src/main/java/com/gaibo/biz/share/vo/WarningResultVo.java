package com.gaibo.biz.share.vo;

import java.util.List;

public class WarningResultVo {
	private List<List<String>> record ;
	private String status ;
	private String message ;
	public List<List<String>> getRecord() {
		return record;
	}
	public void setRecord(List<List<String>> record) {
		this.record = record;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
