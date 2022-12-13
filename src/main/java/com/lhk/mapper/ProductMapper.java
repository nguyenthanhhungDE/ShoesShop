package com.lhk.mapper;

import java.sql.ResultSet;

import com.lhk.model.CategoryModel;
import com.lhk.model.ProductModel;

public class ProductMapper implements ModelMapper<ProductModel>{

	@Override
	public ProductModel mapModel(ResultSet rs) {
		try {
			ProductModel productModel = new ProductModel();
			CategoryModel x = new CategoryModel();
			productModel.setProductid(rs.getString("productid"));
			productModel.setProductname(rs.getString("productname"));
			productModel.setImage(rs.getString("image"));
			productModel.setPrice(rs.getInt("price"));
			productModel.setDiscount(rs.getInt("discount"));
			productModel.setQuantity(rs.getInt("quantity"));
			productModel.setStatus(rs.getInt("status"));
			x.setCategoryid(rs.getString("categoryid"));
			productModel.setCategory(x);
			return productModel;
		} catch (Exception e) {
			return null;
		}
	}

}
