package com.lhk.dao.impl;

import java.util.List;

import com.lhk.dao.IOrderdtoDAO;
import com.lhk.dto.OrderDTO;
import com.lhk.mapper.OrderDTOMapper;

public class OrderdtoDAO extends AbstractDAO<OrderDTO> implements IOrderdtoDAO{
	@Override
	public List<OrderDTO> findAllOrders() {
		String sqlString = "select orderdetails.orderdetailid, products.image, products.productname, orderdetails.quantity, orderdetails.price, orders.orderdate, customers.lastname as lastname, customers.firstname as firstname, orderdetails.status "
				+ "from customers, products, orders, orderdetails "
				+ "where orders.orderid = orderdetails.orderid "
				+ "and orderdetails.productid = products.productid "
				+ "and orders.customerid = customers.customerid "
				+ "order by orders.orderdate desc";
		
		return query(sqlString, new OrderDTOMapper());
	}

	@Override
	public List<OrderDTO> findAllOrderByCustomerId(String cusid) {
		String sqlString = "select orderdetails.orderdetailid, products.image, products.productname, orderdetails.quantity, orderdetails.price, orders.orderdate, customers.lastname as lastname, customers.firstname as firstname, orderdetails.status "
				+ "from customers, products, orders, orderdetails "
				+ "where orders.orderid = orderdetails.orderid "
				+ "and orderdetails.productid = products.productid "
				+ "and orders.customerid = customers.customerid "
				+ "and orders.customerid = ?"
				+ "order by orders.orderdate desc";
		
		return query(sqlString, new OrderDTOMapper(), cusid);
	}
}
