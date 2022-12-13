package com.lhk.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.lhk.dao.IProductDAO;
import com.lhk.dao.IProductdtoDAO;
import com.lhk.dao.ITopProductdtoDAO;
import com.lhk.dto.ProductDTO;
import com.lhk.dto.TopProductDTO;
import com.lhk.model.ProductModel;
import com.lhk.service.IProductService;

public class ProductService implements IProductService{

	
	//private IProductDAO iProductDAO = new ProductDAO();
	@Inject
	private IProductDAO iProductDAO;
	
	@Inject
	private IProductdtoDAO iProductdtoDAO;
	
	@Inject
	private ITopProductdtoDAO iTopProductdtoDAO;
	
	@Override
	public List<ProductModel> findProductByCategoryId(String cid) {
		
		return iProductDAO.findProductByCategoryId(cid);
	}

	@Override
	public List<ProductModel> findAllProduct() {
		
		return iProductDAO.findAllProduct();
	}

	@Override
	public List<ProductModel> findProductByProductId(String pid) {
		
		return iProductDAO.findProductByProductId(pid);
	}

	@Override
	public List<ProductDTO> findAllProducts() {

		return iProductdtoDAO.findAllProducts();
	}

	@Override
	public void insertProduct(ProductModel productModel, String size) {
		iProductDAO.insertProduct(productModel, size);
	}

	@Override
	public void updateProduct(ProductModel productModel) {
		iProductDAO.updateProduct(productModel);
	}

	@Override
	public void removeProduct(String pid) {
		iProductDAO.removeProduct(pid);
	}

	@Override
	public List<ProductModel> searchProductByName(String pname) {
		return iProductDAO.searchProductByName(pname);
	}

	@Override
	public List<TopProductDTO> topProducts() {
		return iTopProductdtoDAO.topProducts();
	}

	@Override
	public List<ProductModel> newProduct() {
		
		return iProductDAO.newProduct();
	}

	@Override
	public List<ProductModel> topProduct() {
		
		return iProductDAO.topProduct();
	}

}
