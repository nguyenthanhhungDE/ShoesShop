package com.lhk.mapper;

import java.sql.ResultSet;

import com.lhk.dto.TopProductDTO;

public class TopProductDTOMapper implements ModelMapper<TopProductDTO>{

	@Override
	public TopProductDTO mapModel(ResultSet rs) {
		try {
			TopProductDTO topProductDTO = new TopProductDTO();
			topProductDTO.setProductid(rs.getString("productid"));
			topProductDTO.setProductname(rs.getString("productname"));
			topProductDTO.setImage(rs.getString("image"));
			topProductDTO.setQuantity(rs.getInt("soluong"));
			topProductDTO.setTotal(rs.getInt("tong"));
			return topProductDTO;
		} catch (Exception e) {
			return null;
		}
	}

}
