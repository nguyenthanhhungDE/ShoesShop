package com.lhk.dao;

import java.util.List;

import com.lhk.model.ProductSizeModel;

public interface IProductSizeDAO extends GenericDAO<ProductSizeModel>{
	List<ProductSizeModel> findProductSizeByProductId(String pid);
}
