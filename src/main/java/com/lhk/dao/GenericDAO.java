package com.lhk.dao;

import java.util.List;

import com.lhk.mapper.ModelMapper;

public interface GenericDAO<T> {
	//<T> List<T> query(String hql, ModelMapper<T> modelMapper, Object... parameters);
	List<T> query(String hql, ModelMapper<T> modelMapper, Object... parameters);
	void insert(String sql, Object... parameters);
	void updateDelete(String sql, Object... parameters);
}
