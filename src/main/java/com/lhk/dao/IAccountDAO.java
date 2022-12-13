package com.lhk.dao;

import com.lhk.model.AccountModel;

public interface IAccountDAO extends GenericDAO<AccountModel>{
	public AccountModel checkLogin(String username, String password);
	AccountModel getAccountByAccountId(String id);
	public void insertAccount(AccountModel accountModel);
	boolean checkAccount(String username);
}
