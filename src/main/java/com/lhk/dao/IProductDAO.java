package com.lhk.dao;

import java.util.List;

import com.lhk.model.ProductModel;

public interface IProductDAO extends GenericDAO<ProductModel>{
	List<ProductModel> findProductByCategoryId(String cid);
	List<ProductModel> findAllProduct();
	List<ProductModel> findProductByProductId(String pid);
	List<ProductModel> searchProductByName(String pname);
	List<ProductModel> newProduct();
	List<ProductModel> topProduct();
	void insertProduct(ProductModel productModel, String size);
	void updateProduct(ProductModel productModel);
	void removeProduct(String pid);
}
