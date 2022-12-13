package com.lhk.service;

import java.util.List;

import com.lhk.dto.ProductDTO;
import com.lhk.dto.TopProductDTO;
import com.lhk.model.ProductModel;

public interface IProductService {
	List<ProductModel> findProductByCategoryId(String cid);
	List<ProductModel> findAllProduct();
	List<ProductModel> findProductByProductId(String pid);
	List<ProductDTO> findAllProducts();
	List<ProductModel> searchProductByName(String pname);
	List<TopProductDTO> topProducts();
	List<ProductModel> newProduct();
	List<ProductModel> topProduct();
	void insertProduct(ProductModel productModel, String size);
	void updateProduct(ProductModel productModel);
	void removeProduct(String pid);
}
