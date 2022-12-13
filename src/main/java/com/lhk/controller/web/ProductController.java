package com.lhk.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhk.model.ProductModel;
import com.lhk.service.ICategoryService;
import com.lhk.service.IProductService;

@WebServlet(urlPatterns = {"/san-pham"})
public class ProductController extends HttpServlet{
	
	@Inject
	private ICategoryService iCategoryService;
	
	@Inject
	private IProductService iProductService;
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("categories", iCategoryService.findAllCategory());
		req.setAttribute("products", iProductService.findAllProduct());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/product.jsp");
		dispatcher.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		
		String cid = req.getParameter("cid");
		//req.removeAttribute("products");
		req.setAttribute("products", null);
		PrintWriter out = resp.getWriter();
		List<ProductModel> productModels = iProductService.findProductByCategoryId(cid);
		for(ProductModel p : productModels) {
			out.println("<div class=\"col-lg-4 col-md-6 lhk\">\r\n"
					+ "								<a href=\"san-pham-chi-tiet?pid="+p.getProductid()+"\">\r\n"
					+ "									<div class=\"single-product single-product-lhk\">\r\n"
					+ "										<img class=\"img-fluid img-lhk\" src=\""+p.getImage()+"\" alt=\"\"/>\r\n"
					+ "										<div class=\"product-details product-details-lhk\">\r\n"
					+ "											<h6>"+p.getProductname()+"</h6>\r\n"
					+ "											<div class=\"price price-lhk\">\r\n"
					+ "												<h6>"+p.getDiscount()+"</h6>\r\n"
					+ "												<h6 class=\"l-through\">"+p.getPrice()+"d</h6>\r\n"
					+ "											</div>\r\n"
					+ "										</div>\r\n"
					+ "									</div>\r\n"
					+ "								</a>\r\n"
					+ "							</div>");
		}
	}
}
