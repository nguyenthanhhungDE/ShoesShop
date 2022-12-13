package com.lhk.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhk.service.IOrderService;
import com.lhk.utils.SessionUtils;

@WebServlet(urlPatterns = {"/admin-edit"})
public class EditOrderController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IOrderService iOrderService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String orderid = req.getParameter("orderid");
		String action = req.getParameter("action");
		
		Object obj = SessionUtils.getInstance().getValue(req, "accountModel");
		
		if (obj != null) {
			if(orderid != "") {
				if(action.equals("D")) {
					iOrderService.updateOrder(orderid, 1);
				}
				else {
					iOrderService.updateOrder(orderid, 2);
				}
			}
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/dang-nhap");
		}
	}
}
