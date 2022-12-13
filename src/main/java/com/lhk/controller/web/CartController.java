package com.lhk.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhk.utils.SessionUtils;

@WebServlet(urlPatterns = {"/gio-hang"})
public class CartController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Object obj = SessionUtils.getInstance().getValue(req, "accountModel");
		
		if (obj != null) {
			req.getRequestDispatcher("/views/web/cart.jsp").forward(req, resp);
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/dang-nhap");
		}
		
	}

}
