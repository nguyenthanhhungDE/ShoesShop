package com.lhk.model;

public class ProductSizeModel {
	
	private int size;
	private ProductModel product;
	
	public ProductSizeModel() {
		super();
	}
	public ProductSizeModel(int size, ProductModel product) {
		super();
		this.size = size;
		this.product = product;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	
}
