package com.lhk.service;

import java.util.List;

import com.lhk.dto.TopCustomerDTO;
import com.lhk.model.CustomerModel;

public interface ICustomerService {
	List<CustomerModel> findUserByAccountId(String accountid);
	List<TopCustomerDTO> topCustomers();
	void updateCustomerDeliveryAddress(String addressdelivery, String customerid);
	void updateCustomer(CustomerModel customerModel);
	void insertCustomer(CustomerModel customerModel);
}
