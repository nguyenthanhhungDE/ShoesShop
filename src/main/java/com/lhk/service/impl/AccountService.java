package com.lhk.service.impl;

import javax.inject.Inject;

import com.lhk.dao.IAccountDAO;
import com.lhk.model.AccountModel;
import com.lhk.service.IAccountService;

public class AccountService implements IAccountService{
	
	@Inject
	private IAccountDAO iAccountDAO;

	@Override
	public AccountModel checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		return iAccountDAO.checkLogin(username, password);
	}

	@Override
	public AccountModel getAccountByAccountId(String id) {
		// TODO Auto-generated method stub
		return iAccountDAO.getAccountByAccountId(id);
	}

	@Override
	public void insertAccount(AccountModel accountModel) {
		iAccountDAO.insertAccount(accountModel);
	}

	@Override
	public boolean checkAccount(String username) {
		return iAccountDAO.checkAccount(username);
	}
	
}
