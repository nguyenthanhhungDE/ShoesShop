package com.lhk.mapper;

import java.sql.ResultSet;

import com.lhk.model.AccountModel;

public class AccountMapper implements ModelMapper<AccountModel>{

	@Override
	public AccountModel mapModel(ResultSet rs) {
		try {
			AccountModel accountModel = new AccountModel();
			accountModel.setAccountid(rs.getString("accountid"));
			accountModel.setUsername(rs.getString("username"));
			accountModel.setPassword(rs.getString("password"));
			accountModel.setIsadmin(rs.getInt("isadmin"));
			return accountModel;
		} catch (Exception e) {
			return null;
		}
	}

}
