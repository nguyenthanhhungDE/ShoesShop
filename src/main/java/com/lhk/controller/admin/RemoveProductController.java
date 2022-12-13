package com.lhk.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhk.service.IProductService;
import com.lhk.utils.SessionUtils;

@WebServlet(urlPatterns = {"/admin-removeproduct"})
public class RemoveProductController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProductService iProductService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object obj = SessionUtils.getInstance().getValue(req, "accountModel");
		
		if (obj != null) {
			String pid = req.getParameter("pid");
			iProductService.removeProduct(pid);
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/dang-nhap");
		}
	}

}
