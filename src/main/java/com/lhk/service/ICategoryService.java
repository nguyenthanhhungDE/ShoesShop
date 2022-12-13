package com.lhk.service;

import java.util.List;

import com.lhk.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAllCategory();
	List<CategoryModel> findCategoryByProductId(String pid);
}
