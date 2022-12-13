package com.lhk.mapper;

import java.sql.ResultSet;

import com.lhk.model.ProductModel;
import com.lhk.model.ProductSizeModel;

public class ProductSizeMapper implements ModelMapper<ProductSizeModel>{

	@Override
	public ProductSizeModel mapModel(ResultSet rs) {
		try {
			ProductSizeModel productSizeModel = new ProductSizeModel();
			ProductModel x = new ProductModel();
			x.setProductid(rs.getString("productid"));
			productSizeModel.setProduct(x);
			productSizeModel.setSize(rs.getInt("size"));
			return productSizeModel;
		} catch (Exception e) {
			return null;
		}
	}

}
