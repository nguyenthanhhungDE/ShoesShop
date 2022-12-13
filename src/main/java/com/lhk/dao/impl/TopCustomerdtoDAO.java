package com.lhk.dao.impl;

import java.util.List;

import com.lhk.dao.ITopCustomerdtoDAO;
import com.lhk.dto.TopCustomerDTO;
import com.lhk.mapper.TopCustomerDTOMapper;

public class TopCustomerdtoDAO extends AbstractDAO<TopCustomerDTO> implements ITopCustomerdtoDAO{

	@Override
	public List<TopCustomerDTO> topCustomers() {
		String sql = "select c.customerid, c.lastname, c.firstname, count(o.orderid) as sodon, sum(od.price) as tong "
				+ "from customers c "
				+ "join orders o "
				+ "on o.customerid = c.customerid "
				+ "join orderdetails od "
				+ "on od.orderid = o.orderid "
				+ "where od.status = 1 "
				+ "group by c.customerid,c.firstname,c.lastname "
				+ "Order by tong desc limit 5";
		return query(sql, new TopCustomerDTOMapper());
	}

}
