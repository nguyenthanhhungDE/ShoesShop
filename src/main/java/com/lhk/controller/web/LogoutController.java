package com.lhk.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhk.utils.SessionUtils;

@WebServlet(urlPatterns = {"/dang-xuat"})
public class LogoutController extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SessionUtils.getInstance().removeValue(req, "accountModel");
		resp.sendRedirect(req.getContextPath() + "/trang-chu");
	}
	
}
