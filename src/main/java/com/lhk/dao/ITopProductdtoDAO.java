package com.lhk.dao;

import java.util.List;

import com.lhk.dto.TopProductDTO;

public interface ITopProductdtoDAO extends GenericDAO<TopProductDTO>{
	List<TopProductDTO> topProducts();
}
