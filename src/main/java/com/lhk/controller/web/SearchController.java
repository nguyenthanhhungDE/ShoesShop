package com.lhk.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhk.model.ProductModel;
import com.lhk.service.IProductService;

@WebServlet(urlPatterns = {"/tim-kiem"})
public class SearchController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProductService iProductService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath() + "/trang-chu");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		String txt = req.getParameter("search");
		
		if (txt.equals("")) {
			List<ProductModel> products = iProductService.findAllProduct();
			
			for(ProductModel p : products) {
				out.println("<div class=\"col-lg-4 col-md-6 lhk\">\r\n"
						+ "								<a href=\"/Jsp_Servlet_MVC/san-pham-chi-tiet?pid="+p.getProductid()+"\">\r\n"
						+ "									<div class=\"single-product single-product-lhk\">\r\n"
						+ "										<img class=\"img-fluid img-lhk\" src=\""+p.getImage()+"\" alt=\"\"/>\r\n"
						+ "										<div class=\"product-details product-details-lhk\">\r\n"
						+ "											<h6>"+p.getProductname()+"</h6>\r\n"
						+ "											<div class=\"price price-lhk\">\r\n"
						+ "												<h6>"+p.getDiscount()+"</h6>\r\n"
						+ "												<h6 class=\"l-through\">"+p.getPrice()+"</h6>\r\n"
						+ "											</div>\r\n"
						+ "										</div>\r\n"
						+ "									</div>\r\n"
						+ "								</a>\r\n"
						+ "							</div>");
			}
		}
		else {
			List<ProductModel> products = iProductService.searchProductByName(txt);
			for(ProductModel p : products) {
				out.println("<div class=\"col-lg-4 col-md-6 lhk\">\r\n"
						+ "								<a href=\"/Jsp_Servlet_MVC/san-pham-chi-tiet?pid="+p.getProductid()+"\">\r\n"
						+ "									<div class=\"single-product single-product-lhk\">\r\n"
						+ "										<img class=\"img-fluid img-lhk\" src=\""+p.getImage()+"\" alt=\"\"/>\r\n"
						+ "										<div class=\"product-details product-details-lhk\">\r\n"
						+ "											<h6>"+p.getProductname()+"</h6>\r\n"
						+ "											<div class=\"price price-lhk\">\r\n"
						+ "												<h6>"+p.getDiscount()+"</h6>\r\n"
						+ "												<h6 class=\"l-through\">"+p.getPrice()+"</h6>\r\n"
						+ "											</div>\r\n"
						+ "										</div>\r\n"
						+ "									</div>\r\n"
						+ "								</a>\r\n"
						+ "							</div>");
			}
		}
	}

}
