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
import com.lhk.utils.SessionUtils;

@WebServlet(urlPatterns = {"/admin-updateproduct"})
public class UpdateProductController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProductService iProductService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object obj = SessionUtils.getInstance().getValue(req, "accountModel");
		
		if (obj != null) {
			String productid = req.getParameter("productid");
			String productname = req.getParameter("productname");
			String image = req.getParameter("image");
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			int price = Integer.parseInt(req.getParameter("price"));
			int discount = Integer.parseInt(req.getParameter("discount"));
			int status = Integer.parseInt(req.getParameter("status"));
			String categoryid = req.getParameter("categoryid");
			CategoryModel x = new CategoryModel();
			x.setCategoryid(categoryid);
			ProductModel productModel = new ProductModel(productid, productname, image, price, discount, quantity, status, x);
			iProductService.updateProduct(productModel);
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/dang-nhap");
		}
	}

}
