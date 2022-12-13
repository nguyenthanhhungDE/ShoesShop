package com.lhk.model;

public class CategoryModel{
	
	private String categoryid;
	private String categoryname;

	public CategoryModel() {
		super();
	}

	public CategoryModel(String categoryid, String categoryname) {
		super();
		this.categoryid = categoryid;
		this.categoryname = categoryname;
	}

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
}
