package com.lhk.mapper;

import java.sql.ResultSet;

import com.lhk.model.OrderDetailModel;
import com.lhk.model.OrderModel;
import com.lhk.model.ProductModel;

public class OrderDetailMapper implements ModelMapper<OrderDetailModel>{

	@Override
	public OrderDetailModel mapModel(ResultSet rs) {
		try {
			OrderDetailModel orderDetailModel = new OrderDetailModel();
			ProductModel x = new ProductModel();
			OrderModel y = new OrderModel();
			orderDetailModel.setOrderdetailid(rs.getString("orderdetailid"));
			orderDetailModel.setPrice(rs.getInt("price"));
			orderDetailModel.setQuantity(rs.getInt("quantity"));
			orderDetailModel.setSize(rs.getInt("size"));
			x.setProductid(rs.getString("productid"));
			orderDetailModel.setProduct(x);
			y.setOrderid(rs.getString("orderid"));
			orderDetailModel.setOrder(y);
			return orderDetailModel;
		} catch (Exception e) {
			return null;
		}
	}

}
