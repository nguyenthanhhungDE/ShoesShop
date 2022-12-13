package com.lhk.model;

public class AdminModel {
	
	private String adminid;
	private AccountModel accountModel;

	public AdminModel() {
		super();
	}

	public AdminModel(String adminid, AccountModel accountModel) {
		super();
		this.adminid = adminid;
		this.accountModel = accountModel;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public AccountModel getAccountModel() {
		return accountModel;
	}

	public void setAccountModel(AccountModel accountModel) {
		this.accountModel = accountModel;
	}

}
