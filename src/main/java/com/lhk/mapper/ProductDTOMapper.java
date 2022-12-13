package com.lhk.mapper;

import java.sql.ResultSet;

import com.lhk.dto.ProductDTO;

public class ProductDTOMapper implements ModelMapper<ProductDTO>{

	@Override
	public ProductDTO mapModel(ResultSet rs) {
		try {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductid(rs.getString("productid"));
			productDTO.setProductname(rs.getString("productname"));
			productDTO.setImage(rs.getString("image"));
			productDTO.setQuantity(rs.getInt("quantity"));
			productDTO.setPrice(rs.getInt("price"));
			productDTO.setDiscount(rs.getInt("discount"));
			productDTO.setStatus(rs.getInt("status"));
			productDTO.setCategoryid(rs.getString("categoryid"));
			productDTO.setCategoryname(rs.getString("categoryname"));
			return productDTO;
		} catch (Exception e) {
			return null;
		}
	}

}
