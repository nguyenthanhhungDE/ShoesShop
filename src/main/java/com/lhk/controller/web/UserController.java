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

import com.lhk.dto.OrderDTO;
import com.lhk.model.AccountModel;
import com.lhk.model.CustomerModel;
import com.lhk.service.IAccountService;
import com.lhk.service.ICustomerService;
import com.lhk.service.IOrderService;
import com.lhk.utils.SessionUtils;

@WebServlet(urlPatterns = {"/nguoi-dung"})
public class UserController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICustomerService iCustomerService;
	
	@Inject
	private IAccountService iAccountService;
	
	@Inject
	private IOrderService iOrderService;
	private Object obj;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		obj = SessionUtils.getInstance().getValue(req, "accountModel");
		
		if (obj != null) {
			req.getRequestDispatcher("/views/web/profile.jsp").forward(req, resp);
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/dang-nhap");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		String action = req.getParameter("action");
		String status = "";
		String clas = "";
		String value = "";
		String checkM = "";
		String checkF = "";
		String checkO = "";
		AccountModel accountModel = (AccountModel)obj;
		CustomerModel customerModel = iCustomerService.findUserByAccountId(accountModel.getAccountid()).get(0);
		AccountModel acc = iAccountService.getAccountByAccountId(customerModel.getAccountModel().getAccountid());
		
		if(action.equals("info")) {
			
			if(customerModel.getGender().equals("Nam")) {
				checkM = "checked";
				value = customerModel.getGender();
			}
			else if (customerModel.getGender().equals("Nu")) {
				checkF = "checked";
				value = customerModel.getGender();
			}
			else {
				checkO = "checked";
				value = "";
			}
			PrintWriter out = resp.getWriter();
			out.println("<div class=\"col-md-6 form-group p_star\">\r\n"
					+ "                                            <span>Họ</span>\r\n"
					+ "                                            <input type=\"text\" class=\"form-control\" id=\"last\" name=\"name\" value=\""+customerModel.getLastname()+"\">\r\n"
					+ "                                        </div>\r\n"
					+ "                                        <div class=\"col-md-6 form-group p_star\">\r\n"
					+ "                                            <span>Tên</span>\r\n"
					+ "                                            <input type=\"text\" class=\"form-control\" id=\"first\" name=\"name\" value=\""+customerModel.getFirstname()+"\">\r\n"
					+ "                                        </div>\r\n"
					+ "                                        <div class=\"col-md-6 form-group p_star\">\r\n"
					+ "                                            <span>Số điện thoại</span>\r\n"
					+ "                                            <input type=\"text\" class=\"form-control\" id=\"number\" name=\"number\" value=\""+customerModel.getPhone()+"\">\r\n"
					+ "                                        </div>\r\n"
					+ "                                        <div class=\"col-md-6 form-group p_star\">\r\n"
					+ "                                            <span>Email</span>\r\n"
					+ "                                            <input type=\"email\" class=\"form-control\" id=\"email\" name=\"compemailany\" value=\""+acc.getUsername()+"\" readonly>\r\n"
					+ "                                        </div>\r\n"
					+ "                                        <div class=\"col-md-12 form-group\">\r\n"
					+ "                                            <fieldset>\r\n"
					+ "                                                <span>Giới tính</span>\r\n"
					+ "                                                <form id=\"myCheck\">\r\n"
					+ "                                                  <input class=\"display\" type=\"radio\" id=\"contactChoice1\" name=\"contact\" value=\"Nam\" "+checkM+"/>\r\n"
					+ "                                                  <label for=\"contactChoice1\">Nam</label>\r\n"
					+ "                                            \r\n"
					+ "                                                  <input class=\"display\" type=\"radio\" id=\"contactChoice2\" name=\"contact\" value=\"Nu\" "+checkF+"/>\r\n"
					+ "                                                  <label for=\"contactChoice2\">Nu</label>\r\n"
					+ "                                            \r\n"
					+ "                                                  <input class=\"display\" type=\"radio\" id=\"contactChoice3\" name=\"contact\" value=\"Khac\" "+checkO+"/>\r\n"
					+ "                                                  <label for=\"contactChoice3\">Khác</label>\r\n"
					+ "                                                </form>\r\n"
					+ "                                              </fieldset>\r\n"
					+ "                                        </div>\r\n"
					+ "                                        <div class=\"col-md-12 form-group p_star\">\r\n"
					+ "                                            <span>Địa chỉ</span>\r\n"
					+ "                                            <input type=\"text\" class=\"form-control\" id=\"add2\" name=\"add2\" value=\""+customerModel.getAddress()+"\">\r\n"
					+ "                                        </div>\r\n"
					+ "                                        <div class=\"col-md-12 form-group\">\r\n"
					+ "                                            <input type=\"button\" class=\"btn btn-success\" id=\"btn\" name=\"btn\" value=\"Lưu\" onclick=\"saveInfo('"+customerModel.getCustomerid()+"')\"></input>\r\n"
					+ "                                        </div>");
		}
		else if(action.equals("ord")){
			String cusid = customerModel.getCustomerid();
			List<OrderDTO> models = iOrderService.findAllOrderByCustomerId(cusid);
			
			PrintWriter out = resp.getWriter();
			int i = 1;
			for(OrderDTO o : models) {
				if(o.getStatus() == 0) {
					status = "Chua duyet";
					clas = "badge-brand";
				}
				else if(o.getStatus() == 1){
					status = "Da duyet";
					clas = "badge-success";
				}
				else {
					status = "Huy";
					clas = "badge-danger";
				}
				out.println("<tr>\r\n"
						+ "                                                        <td>"+i+"</td>\r\n"
						+ "                                                        <td>\r\n"
						+ "                                                            <div class=\"m-r-10\"><img\r\n"
						+ "                                                                    src=\""+o.getImage()+"\" alt=\"user\"\r\n"
						+ "                                                                    class=\"rounded\" width=\"45\"></div>\r\n"
						+ "                                                        </td>\r\n"
						+ "                                                        <td>"+o.getProductname()+" </td>\r\n"
						+ "                                                        <td>"+o.getQuantity()+"</td>\r\n"
						+ "                                                        <td>"+o.getPrice()+"</td>\r\n"
						+ "                                                        <td><span\r\n"
						+ "                                                                class=\"badge-dot "+clas+" mr-1\"></span>"+status+"\r\n"
						+ "                                                        </td>\r\n"
						+ "                                                    </tr>");
				i++;
			}
		}
		else {
			String customerid = req.getParameter("customerid");
			String firstname = req.getParameter("firstname");
			String lastname = req.getParameter("lastname");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			String gender = req.getParameter("gender");
			CustomerModel x = new CustomerModel(customerid, lastname, firstname, gender, phone, address, null, null);
			iCustomerService.updateCustomer(x);
		}
	}

}
