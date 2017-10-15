package com.gaibo.biz.dao;

import java.util.List;

import com.gaibo.biz.share.vo.Product;

public interface IProductDao {
	
	public List<Product> queryProductList();
}
