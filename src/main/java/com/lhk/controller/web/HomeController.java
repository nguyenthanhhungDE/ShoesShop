package com.lhk.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhk.service.ICustomerService;
import com.lhk.service.IProductService;


@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	@Inject
	private ICustomerService iUserService;
	
	@Inject
	private IProductService iProductService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		//Thiết lập tiếng việt
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		req.setAttribute("newproduct", iProductService.newProduct());
		req.setAttribute("tproduct", iProductService.topProduct());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/home.jsp");
		dispatcher.forward(req, resp);
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
