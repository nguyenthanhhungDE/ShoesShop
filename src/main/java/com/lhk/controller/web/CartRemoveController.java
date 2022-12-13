package com.lhk.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhk.model.OrderDetailModel;
import com.lhk.model.OrderModel;
import com.lhk.utils.SessionUtils;

@WebServlet(urlPatterns = {"/xoa-san-pham"})
public class CartRemoveController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pid = req.getParameter("pid");
		OrderModel orderModel = (OrderModel)SessionUtils.getInstance().getValue(req, "orderDetail");
		
		if (pid != null && orderModel != null) {
			List<OrderDetailModel> detailModels = orderModel.getDetailModels();
			for(OrderDetailModel x : detailModels) {
				if (x.getProduct().getProductid().equals(pid)) {
					detailModels.remove(x);
					break;
				}
			}
			SessionUtils.getInstance().putValue(req, "orderDetail", orderModel);
		}
		
	}

}
