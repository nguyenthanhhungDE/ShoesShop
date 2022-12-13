package com.lhk.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhk.model.AccountModel;
import com.lhk.model.OrderModel;
import com.lhk.service.IAccountService;
import com.lhk.service.ICustomerService;
import com.lhk.utils.SessionUtils;

@WebServlet(urlPatterns = {"/dang-nhap"})
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICustomerService iUserService;
	
	@Inject
	private IAccountService iAccountService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		//Thiết lập tiếng việt
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		AccountModel accountModel = iAccountService.checkLogin(username, password);
		
		if(accountModel != null) {
			OrderModel orderModel = new OrderModel();
			SessionUtils.getInstance().putValue(req, "accountModel", accountModel);
			orderModel = (OrderModel)SessionUtils.getInstance().getValue(req, "orderDetail");
			String currentAccid = "";
			String currentOrderAccid = "";
			if (orderModel != null) {
				currentAccid = accountModel.getAccountid();
				currentOrderAccid = orderModel.getCustomerModel().getAccountModel().getAccountid();
			}
			//SessionUtils.getInstance().putValue(req, "orderDetail", orderModel);
			if(accountModel.getIsadmin() == 0) {
				resp.sendRedirect(req.getContextPath() + "/admin-home");
			}
			else {
				// Lay cart da ton tai cua khach hang 
				if(orderModel != null && (currentAccid.equals(currentOrderAccid))) {
					SessionUtils.getInstance().putValue(req, "orderDetail", orderModel);
				}
				else {
//					orderModel = null;
					SessionUtils.getInstance().putValue(req, "orderDetail", null);
				}
				resp.sendRedirect(req.getContextPath() + "/trang-chu");
			}
		}
		else {
			String message = "Username or Password wrong !!!";
			ServletContext sc = getServletContext();
			sc.setAttribute("message", message);
			resp.sendRedirect(req.getContextPath() + "/dang-nhap");
		}
	}

}
