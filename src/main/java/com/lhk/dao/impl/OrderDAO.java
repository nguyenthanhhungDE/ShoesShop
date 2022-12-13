package com.lhk.dao.impl;

import com.lhk.dao.IOrderDAO;
import com.lhk.model.OrderModel;

public class OrderDAO extends AbstractDAO<OrderModel> implements IOrderDAO{

	@Override
	public void insertOrder(OrderModel orderModel) {
		String sql = "INSERT INTO orders values (?, ?, ?)";
		insert(sql, orderModel.getOrderid(), orderModel.getOrderdate(), orderModel.getCustomerModel().getCustomerid());
	}

	@Override
	public void updateOrder(String id, int status) {
		String sql = "UPDATE orderdetails SET status = ? WHERE orderdetailid = ?";
		updateDelete(sql, status, id);
	}
}
