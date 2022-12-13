package com.lhk.dao;

import java.util.List;

import com.lhk.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel>{
	List<CategoryModel> findAllCategory();
	List<CategoryModel> findCategoryByProductId(String pid);
	void save(CategoryModel categoryModel);
	void update(CategoryModel categoryModel);
	void delete(int id);
}
