package com.lhk.model;

public class ProductModel {
	
	private String productid;
	private String productname;
	private String image;
	private int price;
	private int discount;
	private int quantity;
	private int status;
	private CategoryModel category;

	public ProductModel() {
		super();
	}

	public ProductModel(String productid, String productname, String image, int price, int discount, int quantity, int status,
			CategoryModel category) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.image = image;
		this.price = price;
		this.discount = discount;
		this.quantity = quantity;
		this.status = status;
		this.category = category;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getDiscount() {
		return discount;
	}
	
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}
}
