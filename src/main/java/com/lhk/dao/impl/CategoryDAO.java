package com.lhk.dao.impl;

import java.util.List;

import com.lhk.dao.ICategoryDAO;
import com.lhk.mapper.CategoryMapper;
import com.lhk.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{

	@Override
	public List<CategoryModel> findAllCategory() {
		String sqlString = "SELECT * FROM categories";
		return query(sqlString, new CategoryMapper());
	}

	@Override
	public void save(CategoryModel categoryModel) {
		String sql = "INSERT INTO categories values (?, ?)";
		insert(sql, categoryModel.getCategoryid(), categoryModel.getCategoryname());
	}

	@Override
	public void update(CategoryModel categoryModel) {
		String sql = "UPDATE categories set categoryname = ?, icon = ? WHERE categoryid = ?";
		updateDelete(sql, categoryModel.getCategoryname(), categoryModel.getCategoryid());
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM categories WHERE categoryid = ?";
		updateDelete(sql, id);
	}

	@Override
	public List<CategoryModel> findCategoryByProductId(String pid) {
		String sql = "select categories.categoryid, categories.categoryname "
				+ "from products, categories "
				+ "where products.categoryid = categories.categoryid "
				+ "and products.productid = ?";
		return query(sql, new CategoryMapper(), pid);
	}
}
