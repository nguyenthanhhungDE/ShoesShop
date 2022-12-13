package com.lhk.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhk.model.CategoryModel;
import com.lhk.model.ProductModel;
import com.lhk.service.IProductService;
import com.lhk.utils.GenerateId;
import com.lhk.utils.SessionUtils;

@WebServlet(urlPatterns = {"/admin-addproduct"})
public class AddProductController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProductService iProductService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object obj = SessionUtils.getInstance().getValue(req, "accountModel");
		if (obj != null) {
			String productname = req.getParameter("productname");
			String image = req.getParameter("image");
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			int price = Integer.parseInt(req.getParameter("price"));
			int discount = Integer.parseInt(req.getParameter("discount"));
			String size = req.getParameter("size");
			String categoryid = req.getParameter("categoryid");
			String productid = GenerateId.generateId("PR");
			int status = 0;
			if(quantity > 0) {
				status = 1;
			}
			CategoryModel x = new CategoryModel();
			x.setCategoryid(categoryid);
			ProductModel productModel = new ProductModel(productid, productname, image, price, discount, quantity, status, x);
			iProductService.insertProduct(productModel, size);
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/dang-nhap");
		}
	}
}
