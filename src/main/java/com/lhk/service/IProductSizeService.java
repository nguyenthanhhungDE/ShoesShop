package com.lhk.service;

import java.util.List;

import com.lhk.model.ProductSizeModel;

public interface IProductSizeService {
	List<ProductSizeModel> findProductSizeByProductId(String pid);
}
