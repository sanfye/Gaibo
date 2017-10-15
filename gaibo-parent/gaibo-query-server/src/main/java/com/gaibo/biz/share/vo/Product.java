package com.gaibo.biz.share.vo;
/**
 * 产品实体
 * @author Administrator
 *
 */
public class Product {
	private String id;
	private String productCode;
	private String productEnglishName;
	private String productChineseName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductEnglishName() {
		return productEnglishName;
	}
	public void setProductEnglishName(String productEnglishName) {
		this.productEnglishName = productEnglishName;
	}
	public String getProductChineseName() {
		return productChineseName;
	}
	public void setProductChineseName(String productChineseName) {
		this.productChineseName = productChineseName;
	}
	
	
}
