package com.lhk.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderModel {
	
	private String orderid;
	private Date orderdate;
	private CustomerModel customerModel;
	private List<OrderDetailModel> detailModels = new ArrayList<OrderDetailModel>();
	
	public OrderModel() {
		super();
	}
	
	public OrderModel(String orderid, Date orderdate, int status, CustomerModel customerModel, List<OrderDetailModel> detailModels) {
		super();
		this.orderid = orderid;
		this.orderdate = orderdate;
		this.customerModel = customerModel;
		this.detailModels = detailModels;
	}

	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	
	public CustomerModel getCustomerModel() {
		return customerModel;
	}

	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}

	public List<OrderDetailModel> getDetailModels() {
		return detailModels;
	}

	public void setDetailModels(List<OrderDetailModel> detailModels) {
		this.detailModels = detailModels;
	}

	public int sumTotal(List<OrderDetailModel> detailModels) {
		int sum = 0;
		for(OrderDetailModel o : detailModels) {
			sum += o.total();
		}
		return sum;
	}
	
}
