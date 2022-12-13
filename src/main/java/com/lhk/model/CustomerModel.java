package com.lhk.model;

public class CustomerModel {

	private String customerid;
	private String lastname;
	private String firstname;
	private String gender;
	private String phone;
	private String address;
	private String addressdelivery;
	private AccountModel accountModel;
	
	public CustomerModel() {
		super();
	}
	public CustomerModel(String customerid, String lastname, String firstname, String gender, String phone, String address,
			String addressdelivery, AccountModel accountModel) {
		super();
		this.customerid = customerid;
		this.lastname = lastname;
		this.firstname = firstname;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.addressdelivery = addressdelivery;
		this.accountModel = accountModel;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressDelivery() {
		return addressdelivery;
	}
	public void setAddressDelivery(String addressdelivery) {
		this.addressdelivery = addressdelivery;
	}
	public AccountModel getAccountModel() {
		return accountModel;
	}
	public void setAccountModel(AccountModel accountModel) {
		this.accountModel = accountModel;
	}
	
}
