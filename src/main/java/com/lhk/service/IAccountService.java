package com.lhk.service;

import com.lhk.model.AccountModel;

public interface IAccountService {
	public AccountModel checkLogin(String username, String password);
	AccountModel getAccountByAccountId(String id);
	public void insertAccount(AccountModel accountModel);
	boolean checkAccount(String username);
}
