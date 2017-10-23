package com.gaibo.biz.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gaibo.biz.dao.IProductDao;
import com.gaibo.biz.server.IProductService;
import com.gaibo.biz.share.vo.Product;

@Transactional
public class ProductService implements IProductService{
	/**
	 * 查询产品列表
	 */
	@Autowired
	private IProductDao productDao;
	public List<Product> queryProductList() {
		return productDao.queryProductList();
	}
}
