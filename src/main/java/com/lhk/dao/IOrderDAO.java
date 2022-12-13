package com.lhk.dao;

import com.lhk.model.OrderModel;

public interface IOrderDAO extends GenericDAO<OrderModel>{
	void insertOrder(OrderModel orderModel);
	void updateOrder(String id, int status);
}
