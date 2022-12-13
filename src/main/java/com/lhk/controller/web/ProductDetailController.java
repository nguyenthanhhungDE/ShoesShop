package com.lhk.controller.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhk.model.CategoryModel;
import com.lhk.model.ProductModel;
import com.lhk.model.ProductSizeModel;
import com.lhk.service.ICategoryService;
import com.lhk.service.IProductService;
import com.lhk.service.IProductSizeService;

@WebServlet(urlPatterns = {"/san-pham-chi-tiet"})
public class ProductDetailController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProductService iProductService;
	
	@Inject
	private IProductSizeService iProductSizeService;
	
	@Inject
	private ICategoryService iCategoryService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pid = req.getParameter("pid");
		
		List<ProductModel> x = iProductService.findProductByProductId(pid);
		List<ProductSizeModel> y = iProductSizeService.findProductSizeByProductId(pid);
		List<CategoryModel> z = iCategoryService.findCategoryByProductId(pid);
		/*
		 * ProductModel productModel = new ProductModel();
		 * 
		 * productModel = x.get(0);
		 */
		
		req.setAttribute("productdetail", x.get(0));
		req.setAttribute("productsize", y);
		req.setAttribute("category", z.get(0));
		
		req.getRequestDispatcher("/views/web/single-product.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
