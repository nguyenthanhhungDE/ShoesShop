package com.lhk.dao.impl;

import java.util.List;

import com.lhk.dao.IProductDAO;
import com.lhk.mapper.ProductMapper;
import com.lhk.model.ProductModel;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO{

	@Override
	public List<ProductModel> findProductByCategoryId(String cid) {
//		String hqlString = "FROM ProductModel p join fetch p.category where p.category.categoryid = ?1";
		String sqlString = "SELECT * FROM products WHERE categoryid = ? and status = 1";
		return query(sqlString, new ProductMapper(), cid);
//		return null;
	}

	@Override
	public List<ProductModel> findAllProduct() {
		String sql = "SELECT * FROM products WHERE status = 1";
		return query(sql, new ProductMapper());
//		return null;
	}

	@Override
	public List<ProductModel> findProductByProductId(String pid) {
		String sql = "SELECT * FROM products WHERE productid = ?";
		return query(sql, new ProductMapper(), pid);
	}

	@Override
	public void insertProduct(ProductModel productModel, String size) {
		String sqlpro = "INSERT INTO products VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		String sqlprosize = "INSERT INTO productsizes VALUES (?, ?)";
		insert(sqlpro, productModel.getProductid(), productModel.getProductname(), productModel.getImage(), productModel.getPrice(), productModel.getDiscount(), productModel.getQuantity(), productModel.getStatus(), productModel.getCategory().getCategoryid());
		String[] s = size.split("\\s");
		for(String x : s) {
			insert(sqlprosize, productModel.getProductid(), x);
		}
	}

	@Override
	public void updateProduct(ProductModel productModel) {
		String sql = "update products "
				+ "set productname = ?, image = ?, price = ?, discount = ?, quantity = ?, status = ?, categoryid = ? "
				+ "where productid = ?";
		updateDelete(sql, productModel.getProductname(), productModel.getImage(), productModel.getPrice(), productModel.getDiscount(), productModel.getQuantity(), productModel.getStatus(), productModel.getCategory().getCategoryid(), productModel.getProductid());
	}

	@Override
	public void removeProduct(String pid) {
		String sql = "update products "
				+ "set quantity = 0, status = 0 "
				+ "where productid = ?";
		updateDelete(sql, pid);
	}

	@Override
	public List<ProductModel> searchProductByName(String pname) {
		String sql = "select * from products where productname like '%"+pname+"%'";
		return query(sql, new ProductMapper());
	}

	@Override
	public List<ProductModel> newProduct() {
		String sql = "select * from products where status = 1 order by discount limit 8";
		return query(sql, new ProductMapper());
	}

	@Override
	public List<ProductModel> topProduct() {
		String sql = "select * from products where status = 1 order by price desc limit 8";
		return query(sql, new ProductMapper());
	}
}
