package com.lhk.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.lhk.dao.ICategoryDAO;
import com.lhk.model.CategoryModel;
import com.lhk.service.ICategoryService;

public class CategoryService implements ICategoryService{

	@Inject
	private ICategoryDAO iCategoryDAO;
	
	@Override
	public List<CategoryModel> findAllCategory() {
		
		return iCategoryDAO.findAllCategory();
	}

	@Override
	public List<CategoryModel> findCategoryByProductId(String pid) {
		// TODO Auto-generated method stub
		return iCategoryDAO.findCategoryByProductId(pid);
	}
}
