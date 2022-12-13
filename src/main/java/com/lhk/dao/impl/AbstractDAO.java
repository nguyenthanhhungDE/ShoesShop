package com.lhk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lhk.DBConnect.Connect;
import com.lhk.dao.GenericDAO;
import com.lhk.mapper.ModelMapper;

public class AbstractDAO<T> implements GenericDAO<T>{
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<T> query(String hql, ModelMapper<T> modelMapper, Object... parameters) {
		List<T> result = new ArrayList<>(); 
		try {
			con = new Connect().getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(hql);
			setParameter(ps, parameters);
			rs = ps.executeQuery();
			while(rs.next()) {
				result.add(modelMapper.mapModel(rs));
			}
			con.commit();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	@Override
	public void insert(String sql, Object... parameters) {
		try {
			con = new Connect().getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			setParameter(ps, parameters);
			ps.executeUpdate();
			con.commit();
			con.close();
		} catch (Exception e) {
			
		}
	}
	
	@Override
	public void updateDelete(String sql, Object... parameters) {
		try {
			con = new Connect().getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			setParameter(ps, parameters);
			ps.executeUpdate();
			con.commit();
			con.close();
		} catch (Exception e) {
			
		}
	}

	private void setParameter(PreparedStatement ps, Object[] parameters) throws SQLException {
		for(int i = 0; i < parameters.length; i++) {
			Object parameter = parameters[i];
			int index = i + 1;
			if (parameter instanceof Long) {
				ps.setLong(index, (Long) parameter);
			} else if (parameter instanceof String) {
				ps.setString(index, (String) parameter);
			} else if (parameter instanceof Integer) {
				ps.setInt(index, (Integer) parameter);
			} else if (parameter instanceof Timestamp) {
				ps.setTimestamp(index, (Timestamp) parameter);
			} else if (parameter instanceof Date) {
				Date x = (Date) parameter;
				ps.setDate(index, new java.sql.Date(x.getTime()));
			}
			
		}
	}
	
}
