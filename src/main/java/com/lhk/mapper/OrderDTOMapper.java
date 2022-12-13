package com.lhk.mapper;

import java.sql.ResultSet;

import com.lhk.dto.OrderDTO;

public class OrderDTOMapper implements ModelMapper<OrderDTO>{

	@Override
	public OrderDTO mapModel(ResultSet rs) {
		try {
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setOrderdetailid(rs.getString("orderdetailid"));
			orderDTO.setImage(rs.getString("image"));
			orderDTO.setProductname(rs.getString("productname"));
			orderDTO.setQuantity(rs.getInt("quantity"));
			orderDTO.setPrice(rs.getInt("price"));
			orderDTO.setOrderdate(rs.getDate("orderdate"));
			orderDTO.setLastname(rs.getString("lastname"));
			orderDTO.setFirstname(rs.getString("firstname"));
			orderDTO.setStatus(rs.getInt("status"));
			return orderDTO;
		} catch (Exception e) {
			return null;
		}
	}

}
