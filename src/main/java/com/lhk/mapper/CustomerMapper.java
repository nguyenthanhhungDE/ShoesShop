package com.lhk.mapper;

import java.sql.ResultSet;

import com.lhk.model.AccountModel;
import com.lhk.model.CustomerModel;

public class CustomerMapper implements ModelMapper<CustomerModel>{

	@Override
	public CustomerModel mapModel(ResultSet rs) {
		try {
			CustomerModel customerModel = new CustomerModel();
			AccountModel x = new AccountModel();
			customerModel.setCustomerid(rs.getString("customerid"));
			customerModel.setFirstname(rs.getString("firstname"));
			customerModel.setLastname(rs.getString("lastname"));
			customerModel.setGender(rs.getString("gender"));
			customerModel.setPhone(rs.getString("phone"));
			customerModel.setAddress(rs.getString("address"));
			customerModel.setAddressDelivery(rs.getString("addressdelivery"));
			x.setAccountid(rs.getString("accountid"));
			customerModel.setAccountModel(x);
			return customerModel;
		} catch (Exception e) {
			return null;
		}
	}

}
