package com.lhk.mapper;

import java.sql.ResultSet;

import com.lhk.dto.TopCustomerDTO;

public class TopCustomerDTOMapper implements ModelMapper<TopCustomerDTO>{

	@Override
	public TopCustomerDTO mapModel(ResultSet rs) {
		try {
			TopCustomerDTO topCustomerDTO = new TopCustomerDTO();
			topCustomerDTO.setCustomerid(rs.getString("customerid"));
			topCustomerDTO.setLastname(rs.getString("lastname"));
			topCustomerDTO.setFirstname(rs.getString("firstname"));
			topCustomerDTO.setOrdernumber(rs.getInt("sodon"));
			topCustomerDTO.setTotal(rs.getInt("tong"));
			return topCustomerDTO;
		} catch (Exception e) {
			return null;
		}
	}

}
