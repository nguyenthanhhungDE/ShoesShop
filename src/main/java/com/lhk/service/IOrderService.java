package com.lhk.service;

import java.util.List;

import com.lhk.dto.OrderDTO;
import com.lhk.model.OrderModel;

public interface IOrderService {
	void insertOrder(OrderModel orderModel);
	void updateOrder(String id, int status);
	List<OrderDTO> findAllOrders();
	List<OrderDTO> findAllOrderByCustomerId(String cusid);
}
