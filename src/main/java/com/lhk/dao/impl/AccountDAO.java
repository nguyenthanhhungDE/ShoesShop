package com.lhk.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.lhk.dao.IAccountDAO;
import com.lhk.mapper.AccountMapper;
import com.lhk.model.AccountModel;

public class AccountDAO extends AbstractDAO<AccountModel> implements IAccountDAO{

	@Override
	public AccountModel checkLogin(String username, String password) {
		List<AccountModel> x = accountModels(username, password);

		if(x.size() != 0) {
			if(x.get(0).getUsername().equals(username) && x.get(0).getPassword().equals(password)) {
				return x.get(0);
			}
		}
		return null;
	}
	
	private List<AccountModel> accountModels (String username, String password){
		List<AccountModel> x = new ArrayList<>();
		String hql = "SELECT * FROM accounts WHERE username = ? AND password = ?";
		x = query(hql, new AccountMapper(), username, password);
		return x;
	}

	@Override
	public AccountModel getAccountByAccountId(String id) {
		String sql = "SELECT * FROM accounts WHERE accountid = ?";
		return query(sql, new AccountMapper(), id).get(0);
	}

	@Override
	public void insertAccount(AccountModel accountModel) {
		String sql = "INSERT INTO accounts VALUES (?, ?, ?, ?)";
		insert(sql, accountModel.getAccountid(), accountModel.getUsername(), accountModel.getPassword(), accountModel.getIsadmin());
	}

	@Override
	public boolean checkAccount(String username) {
		String sql = "SELECT * FROM accounts WHERE username = ?";
		List<AccountModel> x = query(sql, new AccountMapper(), username);
		if(x.isEmpty()) {
			return true; //Chưa có tài khoản
		}
		return false;
	}
}
