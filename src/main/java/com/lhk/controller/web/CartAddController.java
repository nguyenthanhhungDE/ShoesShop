package com.lhk.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.lhk.model.ProductModel;
import com.lhk.service.ICustomerService;
import com.lhk.service.IProductService;
import com.lhk.utils.SessionUtils;

@WebServlet(urlPatterns = {"/them-gio-hang"})
public class CartAddController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProductService iProductService;
	
	@Inject
	private ICustomerService iCustomerService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object obj = SessionUtils.getInstance().getValue(req, "accountModel");
		if (obj == null) {
			resp.sendRedirect(req.getContextPath() + "/dang-nhap");
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/trang-chu");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/plain");
		
		String pid = req.getParameter("pid");
		int pdiscount = Integer.parseInt(req.getParameter("pdiscount"));
		int qty = 1;
		int size = Integer.parseInt(req.getParameter("size"));
		
		Object acc = SessionUtils.getInstance().getValue(req, "accountModel");
		AccountModel accountModel = (AccountModel)acc;
		String accId = "";
		
		
		
		if (acc == null) {
			resp.sendRedirect(req.getContextPath() + "/dang-nhap");
		}
		else {
			accId = accountModel.getAccountid();
			if (pid != null && accId != null) {
				ProductModel productModel = iProductService.findProductByProductId(pid).get(0);
				CustomerModel customerModel = iCustomerService.findUserByAccountId(accId).get(0);
				if (productModel != null) {
					if (req.getParameter("qty") != null) {
						qty = Integer.parseInt(req.getParameter("qty"));
					}
					Object obj = SessionUtils.getInstance().getValue(req, "orderDetail");
					if (obj == null) { /*Gio hang rong*/
						List<OrderDetailModel> detailModels = new ArrayList<OrderDetailModel>();
						OrderDetailModel orderDetailModel = new OrderDetailModel(null, pdiscount, qty, size, 0, null, productModel);
						detailModels.add(orderDetailModel);
						OrderModel orderModel = new OrderModel(null, null, 0, customerModel, detailModels);
						SessionUtils.getInstance().putValue(req, "orderDetail", orderModel);
					}
					else { /*Gio hang ton tai san pham*/
						
						OrderModel orderModel = (OrderModel)obj;
						List<OrderDetailModel> detailModels = orderModel.getDetailModels();
						boolean check = false;
						for(OrderDetailModel x : detailModels) {
							/*Them san pham da ton tai thi tang so luong*/
							if (x.getProduct().getProductid().equals(pid) && x.getSize() == size) {
								x.setQuantity(x.getQuantity() + qty);
								check = true;
							}
						}
						if (check == false) { /*Them san pham moi chua ton tai*/
							OrderDetailModel x = new OrderDetailModel(null, pdiscount, qty, size, 0, null, productModel);
							detailModels.add(x);
						}
						SessionUtils.getInstance().putValue(req, "orderDetail", orderModel);
					}
					 
				}
			}
		}
	}
}
