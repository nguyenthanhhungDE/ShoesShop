package com.lhk.dao.impl;

import java.util.List;

import com.lhk.dao.IProductSizeDAO;
import com.lhk.mapper.ProductSizeMapper;
import com.lhk.model.ProductSizeModel;

public class ProductSizeDAO extends AbstractDAO<ProductSizeModel> implements IProductSizeDAO{

	@Override
	public List<ProductSizeModel> findProductSizeByProductId(String pid) {
		String sqlString = "SELECT * FROM productsizes WHERE productid = ?";
		return query(sqlString, new ProductSizeMapper(), pid);
	}

}
