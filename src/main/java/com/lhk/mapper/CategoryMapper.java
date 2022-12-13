package com.lhk.mapper;

import java.sql.ResultSet;

import com.lhk.model.CategoryModel;

public class CategoryMapper implements ModelMapper<CategoryModel>{

	@Override
	public CategoryModel mapModel(ResultSet rs) {
		try {
			CategoryModel categoryModel = new CategoryModel();
			categoryModel.setCategoryid(rs.getString("categoryid"));
			categoryModel.setCategoryname(rs.getString("categoryname"));
			return categoryModel;
		} catch (Exception e) {
			return null;
		}
	}

}
