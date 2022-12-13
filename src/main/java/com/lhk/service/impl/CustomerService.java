package com.lhk.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.lhk.dao.ICustomerDAO;
import com.lhk.dao.ITopCustomerdtoDAO;
import com.lhk.dto.TopCustomerDTO;
import com.lhk.model.CustomerModel;
import com.lhk.service.ICustomerService;

public class CustomerService implements ICustomerService{

	@Inject
	private ICustomerDAO iCustomerDAO;
	
	@Inject
	private ITopCustomerdtoDAO iTopCustomerdtoDAO;
	
	@Override
	public List<CustomerModel> findUserByAccountId(String accountid) {
		// TODO Auto-generated method stub
		return iCustomerDAO.findCustomerByAccountId(accountid);
	}

	@Override
	public void updateCustomerDeliveryAddress(String addressdelivery, String customerid) {
		iCustomerDAO.updateCustomerDeliveryAddress(addressdelivery, customerid);
	}

	@Override
	public void updateCustomer(CustomerModel customerModel) {
		iCustomerDAO.updateCustomer(customerModel);
	}

	@Override
	public List<TopCustomerDTO> topCustomers() {
		return iTopCustomerdtoDAO.topCustomers();
	}

	@Override
	public void insertCustomer(CustomerModel customerModel) {
		iCustomerDAO.insertCustomer(customerModel);
	}

}
