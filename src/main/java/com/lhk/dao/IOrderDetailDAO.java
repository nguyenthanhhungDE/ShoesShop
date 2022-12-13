package com.lhk.dao;

import com.lhk.model.OrderDetailModel;

public interface IOrderDetailDAO extends GenericDAO<OrderDetailModel>{
	void insertOrderDetail(OrderDetailModel orderDetailModel);
}
