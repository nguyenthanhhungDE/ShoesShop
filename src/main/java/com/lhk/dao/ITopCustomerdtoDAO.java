package com.lhk.dao;

import java.util.List;

import com.lhk.dto.TopCustomerDTO;

public interface ITopCustomerdtoDAO extends GenericDAO<TopCustomerDTO>{
	List<TopCustomerDTO> topCustomers();
}
