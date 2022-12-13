package com.lhk.dao.impl;

import com.lhk.dao.IOrderDetailDAO;
import com.lhk.model.OrderDetailModel;

public class OrderDetailDAO extends AbstractDAO<OrderDetailModel> implements IOrderDetailDAO{

	@Override
	public void insertOrderDetail(OrderDetailModel orderDetailModel) {
		String sql = "INSERT INTO orderdetails values (?, ?, ?, ?, ?, ?, ?)";
		insert(sql, orderDetailModel.getOrderdetailid(), orderDetailModel.getPrice(), orderDetailModel.getQuantity(), orderDetailModel.getSize(), orderDetailModel.getStatus(), orderDetailModel.getOrder().getOrderid(), orderDetailModel.getProduct().getProductid());
	}
}
