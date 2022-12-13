package com.lhk.mapper;

import java.sql.ResultSet;

public interface ModelMapper<T> {
	T mapModel(ResultSet rs);
}
