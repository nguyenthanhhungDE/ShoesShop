package com.lhk.dao;

import java.util.List;

import com.lhk.dto.ProductDTO;

public interface IProductdtoDAO extends GenericDAO<ProductDTO>{
	List<ProductDTO> findAllProducts();
}
