package com.lhk.model;

public class AccountModel {
	
	private String accountid;
	private String username;
	private String password;
	private int isadmin;
	
	public AccountModel() {
		super();
	}
	public AccountModel(String accountid, String username, String password, int isadmin) {
		super();
		this.accountid = accountid;
		this.username = username;
		this.password = password;
		this.isadmin = isadmin;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(int isadmin) {
		this.isadmin = isadmin;
	}

}
