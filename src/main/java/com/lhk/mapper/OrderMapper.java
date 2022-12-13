package com.lhk.mapper;

import java.sql.ResultSet;

import com.lhk.model.CustomerModel;
import com.lhk.model.OrderDetailModel;
import com.lhk.model.OrderModel;

public class OrderMapper implements ModelMapper<OrderModel>{

	@Override
	public OrderModel mapModel(ResultSet rs) {
		try {
			OrderModel orderModel = new OrderModel();
			CustomerModel x = new CustomerModel();
			OrderDetailModel y = new OrderDetailModel();
			orderModel.setOrderid(rs.getString("orderid"));
			orderModel.setOrderdate(rs.getDate("orderdate"));
			x.setCustomerid(rs.getString("customerid"));
			orderModel.setCustomerModel(x);
			y.setOrder(orderModel);
			return orderModel;
		} catch (Exception e) {
			return null;
		}
	}

}
