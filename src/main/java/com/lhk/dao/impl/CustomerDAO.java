package com.lhk.dao.impl;

import java.util.List;

import com.lhk.dao.ICustomerDAO;
import com.lhk.mapper.CustomerMapper;
import com.lhk.model.CustomerModel;

public class CustomerDAO extends AbstractDAO<CustomerModel> implements ICustomerDAO{

	@Override
	public List<CustomerModel> findCustomerByAccountId(String accountid) {
		String hql = "SELECT * FROM customers WHERE accountid = ?";
		return query(hql, new CustomerMapper(), accountid);
	}

	@Override
	public void updateCustomerDeliveryAddress(String addressdelivery, String customerid) {
		String hql = "UPDATE customers SET addressdelivery = ? WHERE customerid = ?";
		updateDelete(hql, addressdelivery, customerid);
	}

	@Override
	public void updateCustomer(CustomerModel customerModel) {
		String sql = "UPDATE customers SET lastname = ?, firstname = ?, gender = ?, phone = ?, address = ? "
				+ "WHERE customerid = ?";
		updateDelete(sql, customerModel.getLastname(), customerModel.getFirstname(), customerModel.getGender(), customerModel.getPhone(), customerModel.getAddress(), customerModel.getCustomerid());
	}

	@Override
	public void insertCustomer(CustomerModel customerModel) {
		String sql = "INSERT INTO customers VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		insert(sql, customerModel.getCustomerid(), customerModel.getLastname(), customerModel.getFirstname(), customerModel.getGender(), customerModel.getPhone(), customerModel.getAddress(), customerModel.getAddressDelivery(), customerModel.getAccountModel().getAccountid());
	}
}
