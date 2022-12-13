package com.lhk.service.impl;

import javax.inject.Inject;

import com.lhk.dao.IOrderDetailDAO;
import com.lhk.model.OrderDetailModel;
import com.lhk.service.IOrderDetailService;


public class OrderDetailService implements IOrderDetailService{

	@Inject
	private IOrderDetailDAO iOrderDetailDAO;
	
	@Override
	public void insertOrderDetail(OrderDetailModel detailModel) {
		iOrderDetailDAO.insertOrderDetail(detailModel);
	}

}
