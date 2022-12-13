package com.lhk.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.lhk.dao.IOrderDAO;
import com.lhk.dao.IOrderdtoDAO;
import com.lhk.dto.OrderDTO;
import com.lhk.model.OrderModel;
import com.lhk.service.IOrderService;

public class OrderService implements IOrderService{

	@Inject
	private IOrderDAO iOrderDAO;
	
	@Inject
	private IOrderdtoDAO iOrderdtoDAO;
	
	@Override
	public void insertOrder(OrderModel orderModel) {
		iOrderDAO.insertOrder(orderModel);
	}

	@Override
	public List<OrderDTO> findAllOrders() {
		return iOrderdtoDAO.findAllOrders();
	}

	@Override
	public void updateOrder(String id, int status) {
		iOrderDAO.updateOrder(id, status);
	}

	@Override
	public List<OrderDTO> findAllOrderByCustomerId(String cusid) {
		// TODO Auto-generated method stub
		return iOrderdtoDAO.findAllOrderByCustomerId(cusid);
	}

}
