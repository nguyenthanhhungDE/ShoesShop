package com.lhk.controller.web;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhk.model.AccountModel;
import com.lhk.model.CustomerModel;
import com.lhk.service.IAccountService;
import com.lhk.service.ICustomerService;
import com.lhk.utils.GenerateId;

@WebServlet(urlPatterns = {"/dang-ky"})
public class SignInController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IAccountService iAccountService;
	
	@Inject
	private ICustomerService iCustomerService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/views/web/signin.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		
		String lastname = req.getParameter("lastname");
		String firstname = req.getParameter("firstname");
		String phone = req.getParameter("phone");
		String username = req.getParameter("email");
		String password = req.getParameter("password");
		String err = "";
		
		if(username != "" && password != "" && lastname != "" && firstname != "" && phone != "") {
			boolean check = iAccountService.checkAccount(username);
			if (check == false) {
				err += "Tài khoản đã tồn tại";
			}
			else {
				Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				Matcher matcher = pattern.matcher(username);
				if (!matcher.matches()) {
					err += "Email sai định dạng!";
				}
			}
		}
		else {
			err += "Vui lòng nhập đầy đủ thông tin";
		}
		
		if (err.length() > 0) {
			ServletContext sc = getServletContext();
			sc.setAttribute("err", err);
			resp.sendRedirect(req.getContextPath() + "/dang-ky");
		}
		else {
			AccountModel ac = new AccountModel(GenerateId.generateId("ACC"), username, password, 1);
			CustomerModel cus = new CustomerModel(GenerateId.generateId("CU"), lastname, firstname, "", phone, "", "", ac);
			iAccountService.insertAccount(ac);
			iCustomerService.insertCustomer(cus);
			resp.sendRedirect(req.getContextPath() + "/dang-nhap");
		}
		
	}

}
