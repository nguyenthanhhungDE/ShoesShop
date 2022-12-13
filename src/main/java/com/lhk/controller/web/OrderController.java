package com.lhk.controller.web;

import java.io.IOException;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhk.model.AccountModel;
import com.lhk.model.CustomerModel;
import com.lhk.model.OrderDetailModel;
import com.lhk.model.OrderModel;
import com.lhk.service.ICustomerService;
import com.lhk.service.IOrderDetailService;
import com.lhk.service.IOrderService;
import com.lhk.utils.GenerateId;
import com.lhk.utils.SessionUtils;

@WebServlet(urlPatterns = {"/mua-hang"})
public class OrderController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICustomerService iCustomerService; 
	
	@Inject
	private IOrderService iOrderService;
	
	@Inject
	private IOrderDetailService iOrderDetailService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Object obj = SessionUtils.getInstance().getValue(req, "accountModel");
		
		if (obj != null) {
			AccountModel accountModel = (AccountModel)obj;
			CustomerModel customerModel = iCustomerService.findUserByAccountId(accountModel.getAccountid()).get(0);
			req.setAttribute("userModel", customerModel);
			req.getRequestDispatcher("/views/web/checkout.jsp").forward(req, resp);
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/dang-nhap");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String message = req.getParameter("message");
		String option = req.getParameter("option");
		String address = req.getParameter("address");
		String or = GenerateId.generateId("OR");
		String ord = "";
		Date date = new Date();
		
		Object obj = SessionUtils.getInstance().getValue(req, "orderDetail");
		Object acc = SessionUtils.getInstance().getValue(req, "accountModel");
		
		
		if(obj != "" && acc != "") {
			OrderModel orderModel = (OrderModel)obj;
			CustomerModel x = orderModel.getCustomerModel();
			if ((option != "" && message == "") || (option == "" && message == "")) {
				x.setAddressDelivery(address);
				iCustomerService.updateCustomerDeliveryAddress(x.getAddressDelivery(), x.getCustomerid());
				orderModel.setCustomerModel(x);
			}
			else if (option != "" && message != "") {
				x.setAddressDelivery(message);
				iCustomerService.updateCustomerDeliveryAddress(x.getAddressDelivery(), x.getCustomerid());
				orderModel.setCustomerModel(x);
			}
			orderModel.setOrderid(or);
			orderModel.setOrderdate(date);
			iOrderService.insertOrder(orderModel);
			for(OrderDetailModel o : orderModel.getDetailModels()) {
				ord = GenerateId.generateId("ORD");
				o.setOrderdetailid(ord);
				o.setOrder(orderModel);
				iOrderDetailService.insertOrderDetail(o);
			}
			SessionUtils.getInstance().removeValue(req, "orderDetail");
			resp.sendRedirect(req.getContextPath() + "/views/web/success.jsp");
		}
		else {
			if(acc == null) {
				resp.sendRedirect(req.getContextPath() + "/dang-nhap");
			}
		}
	}
}
