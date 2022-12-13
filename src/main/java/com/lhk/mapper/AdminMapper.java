package com.lhk.mapper;

import java.sql.ResultSet;

import com.lhk.model.AccountModel;
import com.lhk.model.AdminModel;

public class AdminMapper implements ModelMapper<AdminModel>{

	@Override
	public AdminModel mapModel(ResultSet rs) {
		try {
			AdminModel adminModel = new AdminModel();
			AccountModel x = new AccountModel();
			adminModel.setAdminid(rs.getString("adminid"));
			x.setAccountid(rs.getString("accountid"));
			adminModel.setAccountModel(x);
			return adminModel;
		} catch (Exception e) {
			return null;
		}
	}

}
