package com.lhk.dao.impl;

import java.util.List;

import com.lhk.dao.ITopProductdtoDAO;
import com.lhk.dto.TopProductDTO;
import com.lhk.mapper.TopProductDTOMapper;

public class TopProductdtoDAO extends AbstractDAO<TopProductDTO> implements ITopProductdtoDAO{

	@Override
	public List<TopProductDTO> topProducts() {
		String sql = "select p.productid, p.productname, p.image, count(od.quantity) as soluong, sum(od.price) as tong "
				+ "from products p "
				+ "join  orderdetails od "
				+ "on p.productid = od.productid "
				+ "join orders o "
				+ "on o.orderid = od.orderid "
				+ "where od.status = 1 "
				+ "group by p.productid,p.productname "
				+ "Order by tong desc limit 5";
		return query(sql, new TopProductDTOMapper());
	}

}
