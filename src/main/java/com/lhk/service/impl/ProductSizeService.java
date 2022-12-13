package com.lhk.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.lhk.dao.IProductSizeDAO;
import com.lhk.model.ProductSizeModel;
import com.lhk.service.IProductSizeService;

public class ProductSizeService implements IProductSizeService{

	@Inject
	private IProductSizeDAO iProductSizeDAO;
	@Override
	public List<ProductSizeModel> findProductSizeByProductId(String pid) {
		// TODO Auto-generated method stub
		return iProductSizeDAO.findProductSizeByProductId(pid);
	}

}
