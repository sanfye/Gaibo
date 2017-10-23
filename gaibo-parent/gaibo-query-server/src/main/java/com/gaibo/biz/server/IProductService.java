package com.gaibo.biz.server;

import java.util.List;

import com.gaibo.biz.share.vo.Product;

public interface IProductService {
	/**
	 * 容器启动时初始化所有产品信息
	 */
	public List<Product> queryProductList();
}
