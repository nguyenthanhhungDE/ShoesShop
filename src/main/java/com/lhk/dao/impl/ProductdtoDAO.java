package com.lhk.dao.impl;

import java.util.List;

import com.lhk.dao.IProductdtoDAO;
import com.lhk.dto.ProductDTO;
import com.lhk.mapper.ProductDTOMapper;

public class ProductdtoDAO extends AbstractDAO<ProductDTO> implements IProductdtoDAO{

	@Override
	public List<ProductDTO> findAllProducts() {
		String sql = "select products.productid, products.productname, products.image, products.quantity, products.price, products.discount, products.status, categories.categoryid, categories.categoryname "
				+ "from products, categories "
				+ "where products.categoryid = categories.categoryid";
		return query(sql, new ProductDTOMapper());
	}

}
