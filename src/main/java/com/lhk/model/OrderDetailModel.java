package com.lhk.model;

public class OrderDetailModel {

	private String orderdetailid;
	private int price;
	private int quantity;
	private int size;
	private int status;
	private OrderModel order;
	private ProductModel product;
	
	public OrderDetailModel() {
		super();
	}
	public OrderDetailModel(String orderdetailid, int price, int quantity, int size, int status, OrderModel order,
			ProductModel product) {
		super();
		this.orderdetailid = orderdetailid;
		this.price = price;
		this.quantity = quantity;
		this.size = size;
		this.status = status;
		this.order = order;
		this.product = product;
	}
	public String getOrderdetailid() {
		return orderdetailid;
	}
	public void setOrderdetailid(String orderdetailid) {
		this.orderdetailid = orderdetailid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSize() {
		return size;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus (int status) {
		this.status = status;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public OrderModel getOrder() {
		return order;
	}
	public void setOrder(OrderModel order) {
		this.order = order;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	
	public int total() {
		return this.quantity * this.price;
	}

}
