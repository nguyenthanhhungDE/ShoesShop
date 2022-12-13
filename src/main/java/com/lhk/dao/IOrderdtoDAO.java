package com.lhk.dao;

import java.util.List;

import com.lhk.dto.OrderDTO;

public interface IOrderdtoDAO extends GenericDAO<OrderDTO>{
	List<OrderDTO> findAllOrders();
	List<OrderDTO> findAllOrderByCustomerId(String cusid);
}
