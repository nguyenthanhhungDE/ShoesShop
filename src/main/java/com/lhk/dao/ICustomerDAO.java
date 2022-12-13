package com.lhk.dao;

import java.util.List;

import com.lhk.model.CustomerModel;

public interface ICustomerDAO extends GenericDAO<CustomerModel>{
	List<CustomerModel> findCustomerByAccountId(String accountid);
	void updateCustomerDeliveryAddress(String addressdelivery, String customerid);
	void updateCustomer(CustomerModel customerModel);
	void insertCustomer(CustomerModel customerModel);
}
